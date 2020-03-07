package com.example.messenger.service.impl;

import com.example.messenger.dao.UserDao;
import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.service.PasswordService;
import com.example.messenger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordService passwordService;
    private final UserDao userDao;

    @Override
    public boolean saveUser(UserRegisterDto user) {
        UserRegisterDto userWithEncodedPassword = user.toBuilder()
                .password(passwordService.encodePassword(user.getPassword()))
                .build();
        int userId = userDao.saveUser(userWithEncodedPassword);
        return isUserSaved(userId) && userDao.saveRole(userId, user.getRole());
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id)
                .orElseThrow();
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    private boolean isUserSaved(int userId) {
        return userId > INTEGER_ZERO;
    }
}
