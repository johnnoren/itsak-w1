package com.example.sql_injection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class ThymeController {

    private final RestTemplate restTemplate;

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
