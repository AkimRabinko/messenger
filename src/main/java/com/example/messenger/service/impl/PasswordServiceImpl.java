package com.example.messenger.service.impl;

import com.example.messenger.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PasswordServiceImpl implements PasswordService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
