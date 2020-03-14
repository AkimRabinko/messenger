package com.example.messenger.encryption.service.impl;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncryptionServiceImpl implements EncryptionService {
    private final Cipher cipher;

    @Override
    public String encrypt(String decrypted) {
       try {
           byte[] encrypted = cipher.doFinal(decrypted.getBytes());
           return Base64.encodeBase64String(encrypted);
       } catch (Exception e) {
           log.error("Error during string encryption {}", decrypted, e);
       }
       return decrypted;
    }

    @Override
    public String decrypt(String encrypted) {
        try {
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            return new String(original);
        } catch (Exception e) {
            log.error("Error during string decrypt {}", encrypted, e);
        }
        return encrypted;
    }
}
