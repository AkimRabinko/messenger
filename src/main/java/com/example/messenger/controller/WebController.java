package com.example.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
}
