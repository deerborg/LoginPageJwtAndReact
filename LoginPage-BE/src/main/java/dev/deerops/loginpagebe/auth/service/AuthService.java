package dev.deerops.loginpagebe.auth.service;

import dev.deerops.loginpagebe.auth.model.dto.request.AuthRequest;
import dev.deerops.loginpagebe.auth.model.dto.response.AuthResponse;
import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
}
