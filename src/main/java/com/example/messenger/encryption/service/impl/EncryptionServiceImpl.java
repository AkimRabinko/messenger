package com.example.messenger.encryption.service.impl;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncryptionServiceImpl implements EncryptionService {
    /**
     * key should have 16 bytes length
     */
    @Value("#{environment.AES_ENCRYPTION_KEY}")
    private String encryptionKey;

    private static final int MULTIPLICITY = 16;
    private static final String SHA_ALGORITHM = "SHA-1";
    private static final String AES_ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    private SecretKeySpec secretKey;

    @PostConstruct
    public void before() {
        try {
            byte[] encryptionKeyBytes = encryptionKey.getBytes(StandardCharsets.UTF_8);
            MessageDigest sha = MessageDigest.getInstance(SHA_ALGORITHM);
            byte[] hash = sha.digest(encryptionKeyBytes);
            byte[] key = Arrays.copyOf(hash, MULTIPLICITY);
            secretKey = new SecretKeySpec(key, AES_ALGORITHM);
        } catch (Exception e) {
            log.error("Error during secret key creation: ", e);
        }
    }

    @Override
    public String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return new String(Base64.encodeBase64(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            log.error("Error while encrypting {}: ", value, e);
        }
        return value;
    }

    @Override
    public String decrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(value)));
        } catch (Exception e) {
            log.error("Error while decrypting {}: ", value, e);
        }
        return value;
    }
}
