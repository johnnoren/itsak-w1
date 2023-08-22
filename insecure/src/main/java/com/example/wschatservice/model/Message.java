package com.example.wschatservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private String sender;

    public Message(String message, String sender) {
        this.message = message;
        this.sender = sender;
    }


}
