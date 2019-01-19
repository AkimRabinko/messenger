package com.example.messenger.dao.impl;

import com.example.messenger.dao.UserDao;
import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

    public int create(UserRegisterDto user) {
        return 0;
    }

    public int update(UserRegisterDto user) {
        return 0;
    }

    public User getById(int id) {
        return null;
    }

    public List<User> getAll() {
        return null;
    }

    public int delete(int id) {
        return 0;
    }
}
