package dev.deerops.loginpagebe.auth.controller;

import dev.deerops.loginpagebe.auth.model.dto.request.AuthRequest;
import dev.deerops.loginpagebe.auth.model.dto.response.AuthResponse;
import dev.deerops.loginpagebe.auth.service.AuthService;
import dev.deerops.loginpagebe.user.model.util.UserControllerContains;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserControllerContains.AUTH_BASE_URL)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @CrossOrigin
    @PostMapping(UserControllerContains.PUBLIC+UserControllerContains.LOGIN)
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest){
        return authService.authenticate(authRequest);
    }

}
