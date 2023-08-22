package com.example.wschatservice.controller;
import com.example.wschatservice.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {



    @MessageMapping("/talk")
    @SendTo("/topic/listen")
    public Message receiveMessage(@Payload Message message) {
        System.out.println(message);
        return message;
    }

}
