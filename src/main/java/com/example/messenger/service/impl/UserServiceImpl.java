package com.example.messenger.service.impl;

import com.example.messenger.dao.UserDao;
import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.service.UserService;
import com.example.messenger.util.EncoderUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private static final int NOT_SAVED = -1;
    private final UserDao userDao;

    @Override
    public boolean saveUser(UserRegisterDto user) {
        user.setPassword(EncoderUtils.getMd5(user.getPassword()));
        int userId = userDao.saveUser(user);
        return userId != NOT_SAVED && userDao.saveRole(userId, user.getRole());
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }
}
