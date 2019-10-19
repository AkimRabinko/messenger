package com.example.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.Objects.isNull;

@Controller
public class WebController {
    private static final String INVALID_EMAIL_OR_PASSWORD_MESSAGE = "Invalid Email";

    @GetMapping(value = "/login")
    public String getLoginPage(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("error", isNull(error) ? "" : INVALID_EMAIL_OR_PASSWORD_MESSAGE);
        return "login";
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
