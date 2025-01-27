package dev.deerops.loginpagebe.message.controller;

import dev.deerops.loginpagebe.common.util.result.ApiResponse;
import dev.deerops.loginpagebe.message.model.entity.MessageEntity;
import dev.deerops.loginpagebe.message.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/public/send")
    public ResponseEntity<ApiResponse<MessageEntity>> createdMessage(@RequestBody MessageEntity message){
        return messageService.createdMessage(message);
    }

    @GetMapping("/private/messages")
    public ResponseEntity<ApiResponse<List<MessageEntity>>> getAllMessage(){
        return messageService.getAllMessages();
    }
}
