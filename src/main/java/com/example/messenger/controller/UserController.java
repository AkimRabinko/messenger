package com.example.messenger.controller;

import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("save")
    public boolean saveUser(UserRegisterDto user) {
       return userService.saveUser(user);
    }

    @PutMapping("update")
    public boolean updateUser(User user) {
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
}
