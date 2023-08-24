package com.example.sql_injection.controller;
import com.example.sql_injection.model.User;
import com.example.sql_injection.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class PublicController {


    private final UserRepository pRepo;

    public PublicController(UserRepository pRepo) {
        this.pRepo = pRepo;
    }


    @PostMapping("/public/register")
    public String addUser(@RequestBody User user) {
        User savedUser = pRepo.save(user);
        return savedUser.getUsername()+" added to database successfully";
    }

    @RequestMapping("/public/all")
    public List<User> getAllPersons(){
        return pRepo.findAll();
    }
    }