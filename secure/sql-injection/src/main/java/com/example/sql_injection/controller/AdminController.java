package com.example.sql_injection.controller;

import com.example.sql_injection.model.User;
import com.example.sql_injection.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    private final UserRepository pRepo;

    public AdminController(UserRepository pRepo) {
        this.pRepo = pRepo;
    }


    @RequestMapping("/admin/all")
    public List<User> getAllPersons(){
        return pRepo.findAll();
    }
}
