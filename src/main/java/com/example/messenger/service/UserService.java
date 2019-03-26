package com.example.messenger.service;

import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;

public interface UserService {
    boolean saveUser(UserRegisterDto user);

    boolean updateUser(User user);

    User getUser(int id);

    boolean deleteUser(int id);
}
