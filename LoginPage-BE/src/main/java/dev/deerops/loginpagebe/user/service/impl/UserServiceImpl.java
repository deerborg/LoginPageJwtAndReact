package dev.deerops.loginpagebe.user.service.impl;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.common.util.result.ResponseHelper;
import dev.deerops.loginpagebe.user.model.dto.request.CreateUserRequest;
import dev.deerops.loginpagebe.user.model.dto.response.UserResponse;
import dev.deerops.loginpagebe.user.model.entity.Role;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import dev.deerops.loginpagebe.user.model.mapper.UserDtoConverter;
import dev.deerops.loginpagebe.user.model.util.exceptions.UserGeneralValidationsException;
import dev.deerops.loginpagebe.user.model.util.validations.UserValidation;
import dev.deerops.loginpagebe.user.repository.UserRepository;
import dev.deerops.loginpagebe.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final UserValidation userValidation;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter, UserValidation userValidation, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.userValidation = userValidation;
        this.encoder = encoder;
    }

    @Override
    public ResponseEntity<ApiResponse<UserResponse>> createUserForRegister(CreateUserRequest createUserRequest) {

        userValidation.validateUserField(
                createUserRequest.getUsername(), createUserRequest.getEmail(), createUserRequest.getPassword());

        if (userRepository.existsByUsernameOrEmail(createUserRequest.getUsername(), createUserRequest.getEmail())) {
            throw new UserGeneralValidationsException("Exist username or email");
        }

        UserEntity user = userDtoConverter.fromCreateUserToEntity(createUserRequest);

        user.setPassword(encoder.encode(user.getPassword()));

        user.setCreateAt(LocalDateTime.now());

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        user.setRole(Collections.singletonList(Role.ADMIN));
        user.setEnabledAt(LocalDateTime.now());

        UserResponse response = userDtoConverter
                .fromUserEntityToResponse(userRepository.save(user));

        return new ResponseEntity<>(ResponseHelper.CREATE(response), HttpStatus.CREATED);
    }
}
