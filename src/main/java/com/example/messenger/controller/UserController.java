package com.example.messenger.controller;

import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("save")
    public boolean saveUser(@RequestBody UserRegisterDto user) {
        return userService.saveUser(user);
    }

    @PutMapping("update")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public Principal getPrincipal(Principal principal) {
        return principal;
    }
}
