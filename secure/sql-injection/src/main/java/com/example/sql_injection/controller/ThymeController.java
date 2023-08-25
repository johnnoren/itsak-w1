package com.example.sql_injection.controller;

import com.example.sql_injection.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class ThymeController {

    private final RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "Get all users")
    @RequestMapping("/users")
    public String getAllUsers(Model model, Principal principal) {
        model.addAttribute("userList", userRepository.findAll());
        model.addAttribute("currentRole", getCurrentRole(principal));
        return "users.html";
    }

    public ThymeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String getCurrentRole(Principal principal) {
        if (principal != null) {
            return principal.getName();
        } else {
            return "ej inloggad";
        }
    }

    @RequestMapping({"/index", "/", "", "/login"})
    public String getIndex(Model model, Principal principal) {
        model.addAttribute("currentRole", getCurrentRole(principal));
        return "index.html";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model, Principal principal) {
        model.addAttribute("currentRole", getCurrentRole(principal));
        model.addAttribute("loginError", true);
        return "index.html";
    }

}
