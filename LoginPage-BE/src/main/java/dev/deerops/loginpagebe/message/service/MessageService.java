package dev.deerops.loginpagebe.message.service;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.message.model.entity.MessageEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    ResponseEntity<ApiResponse<MessageEntity>> createdMessage(MessageEntity message);
    ResponseEntity<ApiResponse<List<MessageEntity>>> getAllMessages();
    ResponseEntity<?> forInVisibleMessageId(String id);
    ResponseEntity<?> deleteForPermanentMessage(String id);
}
