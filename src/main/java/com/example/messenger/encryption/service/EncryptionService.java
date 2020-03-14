package com.example.messenger.encryption.service;

public interface EncryptionService {
    String encrypt(String decrypted);

    String decrypt(String encrypted);
}
