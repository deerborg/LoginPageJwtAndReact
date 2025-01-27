package dev.deerops.loginpagebe.user.model.mapper;

import dev.deerops.loginpagebe.user.model.dto.request.CreateUserRequest;
import dev.deerops.loginpagebe.user.model.dto.response.UserResponse;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserDtoConverterImpl implements UserDtoConverter{

    @Override
    public UserEntity fromCreateUserToEntity(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(request.getUsername());
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());

        userEntity.setCreateAt(LocalDateTime.now());

        return userEntity;
    }

    @Override
    public UserResponse fromUserEntityToResponse(UserEntity entity) {
        UserResponse userResponse = new UserResponse();

        userResponse.setUserId(entity.getUserId());
        userResponse.setCreateAt(entity.getCreateAt());

        return userResponse;
    }
}
