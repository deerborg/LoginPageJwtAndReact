package dev.deerops.loginpagebe.message.service.impl;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.common.util.result.ResponseHelper;
import dev.deerops.loginpagebe.message.model.entity.MessageEntity;
import dev.deerops.loginpagebe.message.repository.MessageRepository;
import dev.deerops.loginpagebe.message.service.MessageService;
import dev.deerops.loginpagebe.user.model.util.exceptions.UserGeneralValidationsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public ResponseEntity<ApiResponse<MessageEntity>> createdMessage(MessageEntity message) {
        if(message.getEmail().trim().isEmpty() || message.getMessage().trim().isEmpty()){
            throw new UserGeneralValidationsException("Field cannot empty");
        }
        message.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(ResponseHelper.CREATE(messageRepository.save(message)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<List<MessageEntity>>> getAllMessages() {
        return new ResponseEntity<>(ResponseHelper.SUCCESS(messageRepository.findAll()),HttpStatus.OK);
    }
}
