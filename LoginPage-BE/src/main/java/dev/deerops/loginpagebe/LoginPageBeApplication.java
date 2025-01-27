package dev.deerops.loginpagebe;

import dev.deerops.loginpagebe.user.model.entity.Role;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import dev.deerops.loginpagebe.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootApplication
public class LoginPageBeApplication  {



    public static void main(String[] args) {
        SpringApplication.run(LoginPageBeApplication.class, args);
    }

}
