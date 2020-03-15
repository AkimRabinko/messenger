package com.example.messenger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

@Slf4j
@EnableAspectJAutoProxy
@SpringBootApplication
public class MessengerApplication {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";

    /**
     * @param key should have 16 bytes length
     * @param initVector should have 16 bytes length
     */
    @Value("#{environment.AES_ENCRYPTION_KEY}")
    private String key;
    @Value("#{environment.INIT_VECTOR}")
    private String initVector;

    public static void main(String[] args) {
        SpringApplication.run(MessengerApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IvParameterSpec ivParameterSpec() {
        return new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
    }

    @Bean
    public SecretKeySpec secretKeySpec() {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG") ;
            secureRandom.setSeed(key.getBytes(StandardCharsets.UTF_8));
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            return new SecretKeySpec(enCodeFormat, ALGORITHM);
        } catch (Exception e) {
            log.error("Error during encryption creation");
            throw new NoSuchBeanDefinitionException(e.getMessage());
        }
    }

    @Bean
    public Cipher cipherEncrypt(IvParameterSpec ivParameterSpec, SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            return cipher;
        } catch (Exception e) {
            log.error("Error during encryption creation");
            throw new NoSuchBeanDefinitionException(e.getMessage());
        }
    }

    @Bean
    public Cipher cipherDecrypt(IvParameterSpec ivParameterSpec, SecretKeySpec secretKeySpec) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            return cipher;
        } catch (Exception e) {
            log.error("Error during encryption creation");
            throw new NoSuchBeanDefinitionException(e.getMessage());
        }
    }
}
