package com.example.wschatservice.model;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class IncomingMessage {

    private String message;
    private String sender;

    public IncomingMessage(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }


}
