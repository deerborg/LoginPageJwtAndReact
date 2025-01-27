package dev.deerops.loginpagebe.user.service;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.user.model.dto.request.CreateUserRequest;
import dev.deerops.loginpagebe.user.model.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(CreateUserRequest createUserRequest);
}
