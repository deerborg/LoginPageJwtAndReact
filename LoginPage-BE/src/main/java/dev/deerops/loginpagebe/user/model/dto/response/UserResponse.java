package dev.deerops.loginpagebe.user.model.dto.response;

import java.time.LocalDateTime;

public class UserResponse {
    private String userId;
    private LocalDateTime createAt;


    public UserResponse(String userId, LocalDateTime createAt) {
        this.userId = userId;
        this.createAt = createAt;
    }

    public UserResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}

