package dev.deerops.loginpagebe.user.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    OWNER,ADMIN,MOD,USER;
    @Override
    public String getAuthority() {
        return name();
    }
}
