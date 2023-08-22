package com.example.wschatservice.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ActiveUsers {

    private Map<String, LocalDateTime> activeUsers = new HashMap<>();


    public void add(String username) {
        activeUsers.put(username, LocalDateTime.now());
    }

    public List<String> getActiveUsers() {
        Map<String, LocalDateTime> updatedUsersList = new HashMap<>();
        activeUsers.forEach((k, v) -> {
            if (v.isAfter(LocalDateTime.now().minusMinutes(1))) {
                updatedUsersList.put(k, v);
            }
        });
        activeUsers = updatedUsersList;
        return new ArrayList<>(activeUsers.keySet());
    }

    public void keepAlive(String username) {
        activeUsers.put(username, LocalDateTime.now());
    }

    public void remove(String username) {
        activeUsers.remove(username);
    }
}
