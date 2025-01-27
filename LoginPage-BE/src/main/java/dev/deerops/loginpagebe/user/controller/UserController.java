package dev.deerops.loginpagebe.user.controller;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.user.model.dto.request.CreateUserRequest;
import dev.deerops.loginpagebe.user.model.dto.response.UserResponse;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import dev.deerops.loginpagebe.user.model.util.UserControllerContains;
import dev.deerops.loginpagebe.user.repository.UserRepository;
import dev.deerops.loginpagebe.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserControllerContains.USER_BASE_URL)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(UserControllerContains.PRIVATE+UserControllerContains.REGISTER)
    public ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(@RequestBody CreateUserRequest createUserRequest){
        return userService.createUserForRegister(createUserRequest);
    }

}
