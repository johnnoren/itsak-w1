package com.example.wschatservice.controller;

import com.example.wschatservice.model.Message;
import com.example.wschatservice.repository.MessageRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/talk")
    @SendTo("/listen")
    public Message receiveMessage(Message message) {
        messageRepository.save(message);
        return message;
    }

}
