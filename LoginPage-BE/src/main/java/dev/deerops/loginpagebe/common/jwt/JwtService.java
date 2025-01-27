package dev.deerops.loginpagebe.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;


    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())

                .setIssuedAt(new Date())

                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))

                .signWith(getKey(), SignatureAlgorithm.HS256)

                .compact();
    }

    public Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public <T> T exportToken(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = Jwts.parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claimsTFunction.apply(claims);
    }

    public String getUsernameByToken(String token) {
        return exportToken(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date nowDate = new Date();

        Date expiredDate = exportToken(token, Claims::getExpiration);
        return nowDate.before(expiredDate);
    }


}
