package com.example.messenger.encryption.service;

public interface EncryptionService {
    String encrypt(String value);

    String decrypt(String value);
}
