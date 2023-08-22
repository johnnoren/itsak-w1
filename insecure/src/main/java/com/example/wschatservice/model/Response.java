package com.example.wschatservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class Response {

    private String message;
    private String sender;
    private List<String> activeUsers;

    public Response(String message, String sender, List<String> activeUsers) {
        this.message = message;
        this.sender = sender;
        this.activeUsers = activeUsers;
    }



}
