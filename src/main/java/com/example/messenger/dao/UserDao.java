package com.example.messenger.dao;

import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.model.enums.UserRole;

import java.util.Optional;

public interface UserDao {
    int saveUser(UserRegisterDto user);

    boolean saveRole(int userId, UserRole role);

    boolean updateUser(User user);

    Optional<User> getUser(int id);

    boolean deleteUser(int id);
}
