package dev.deerops.loginpagebe.message.repository;

import dev.deerops.loginpagebe.message.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,String> {
}
