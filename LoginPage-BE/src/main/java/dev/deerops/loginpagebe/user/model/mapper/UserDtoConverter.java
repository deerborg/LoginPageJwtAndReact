package dev.deerops.loginpagebe.user.model.mapper;

import dev.deerops.loginpagebe.user.model.dto.request.CreateUserRequest;
import dev.deerops.loginpagebe.user.model.dto.response.UserResponse;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;

public interface UserDtoConverter {
    UserEntity fromCreateUserToEntity(CreateUserRequest request);
    UserResponse fromUserEntityToResponse(UserEntity entity);
}
