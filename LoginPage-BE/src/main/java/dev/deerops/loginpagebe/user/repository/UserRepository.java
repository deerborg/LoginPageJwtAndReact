package dev.deerops.loginpagebe.user.repository;

import dev.deerops.loginpagebe.user.model.entity.Role;
import dev.deerops.loginpagebe.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String > {

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    boolean existsByUsernameOrEmail(String username,String email);
    List<UserEntity> findByRole(Role role);

}
