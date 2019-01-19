package com.example.messenger.dao;

import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;

import java.util.List;

public interface UserDao {
    int create(UserRegisterDto user);

    int update(UserRegisterDto user);

    User getById(int id);

    List<User> getAll();

    int delete(int id);
}
