package dev.deerops.loginpagebe.common.config;

import dev.deerops.loginpagebe.user.model.entity.Role;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import dev.deerops.loginpagebe.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
@Component
public class AdminUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @Value("${server.dev.pass}")
    private String serverDevPassword;

    public AdminUserInitializer(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            String password = encoder.encode(serverDevPassword);
            UserEntity rootUser = new UserEntity();
            rootUser.setUsername("deerborg");
            rootUser.setPassword(password);
            rootUser.setRole(Collections.singletonList(Role.OWNER));
            rootUser.setEmail("bilginuskudar34@hotmail.com");
            rootUser.setEnabled(true);
            rootUser.setCredentialsNonExpired(true);
            rootUser.setAccountNonLocked(true);
            rootUser.setAccountNonExpired(true);
            rootUser.setCreateAt(LocalDateTime.now());


            userRepository.save(rootUser);
        }
    }
}
