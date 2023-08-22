package com.example.wschatservice.controller;
import com.example.wschatservice.model.IncomingMessage;
import com.example.wschatservice.model.Response;
import com.example.wschatservice.service.ActiveUsers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

private final ActiveUsers activeUsers;

public MessageController(ActiveUsers activeUsers) {
    this.activeUsers = activeUsers;
}

    @MessageMapping("/talk")
    @SendTo("/topic/listen")
    public Response receiveMessage(@Payload IncomingMessage message) {
        activeUsers.add(message.getSender());
        System.out.println(message);
        return new Response(message.getMessage(), message.getSender(), activeUsers.getActiveUsers());
    }

    @MessageMapping("/keepalive")
    public void keepAlive(@Payload String username) {
        activeUsers.keepAlive(username);
    }

}
