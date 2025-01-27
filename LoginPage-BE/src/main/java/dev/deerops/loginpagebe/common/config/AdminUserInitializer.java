package dev.deerops.loginpagebe.common.config;

import dev.deerops.loginpagebe.user.model.entity.Role;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import dev.deerops.loginpagebe.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
@Component
public class AdminUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AdminUserInitializer(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count() == 0){
            String password = encoder.encode("eyJhbGciOiJIUzI1NiJ9.ew0KICAic3ViIjogIjEyMzQ1Njc4OTAiLA0KICAibmFtZSI6ICJBbmlzaCBOYXRoIiwNCiAgImlhdCI6IDE1MTYyMzkwMjINCn0.GbjLqC2MrMUek3SMKpDlCgDAI60DQGNux_JuTgHbv2M");
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
