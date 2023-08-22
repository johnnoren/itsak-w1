package com.example.wschatservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Message {

    private String message;
    private String sender;

    public Message(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }


}
