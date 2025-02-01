package dev.deerops.loginpagebe.message.service.impl;

import dev.deerops.loginpagebe.common.util.exceptions.NotFoundEntityException;
import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.common.util.result.ResponseHelper;
import dev.deerops.loginpagebe.message.model.entity.MessageEntity;
import dev.deerops.loginpagebe.message.model.util.exceptions.InvalidOrEmptyMailException;
import dev.deerops.loginpagebe.message.model.util.exceptions.InvalidOrEmptyMessageException;
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
        if(message.getEmail().trim().isEmpty()){
            throw new InvalidOrEmptyMailException("Invalid or empty e-mail");
        }
        if(message.getMessage().trim().isEmpty()){
            throw new InvalidOrEmptyMessageException("Invalid or empty messages");
        }
        message.setCreatedAt(LocalDateTime.now());

        return new ResponseEntity<>(ResponseHelper.CREATE(messageRepository.save(message)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<List<MessageEntity>>> getAllMessages() {
        return new ResponseEntity<>(ResponseHelper.SUCCESS(messageRepository.findAll()),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> forInVisibleMessageId(String id) {
        MessageEntity message = messageRepository.findById(id)
                .orElseThrow(()-> new NotFoundEntityException("Not found messages ID"));

        message.setDeletedAt(LocalDateTime.now());
        message.setVisible(false);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String deletedStaff = authentication.getName();

        message.setDeletedByStaff(deletedStaff);

        return new ResponseEntity<>(ResponseHelper.UPDATED(messageRepository.saveAndFlush(message)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteForPermanentMessage(String id) {

        return null;
    }
}
