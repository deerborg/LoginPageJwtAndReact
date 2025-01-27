package dev.deerops.loginpagebe.message.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String messageId;

    private String email;

    private String message;

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    private String deletedByStaff;


    public MessageEntity(String messageId, String email, String message, LocalDateTime createdAt, LocalDateTime deletedAt, String deletedByStaff) {
        this.messageId = messageId;
        this.email = email;
        this.message = message;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.deletedByStaff = deletedByStaff;
    }

    public MessageEntity() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDeletedByStaff() {
        return deletedByStaff;
    }

    public void setDeletedByStaff(String deletedByStaff) {
        this.deletedByStaff = deletedByStaff;
    }
}
