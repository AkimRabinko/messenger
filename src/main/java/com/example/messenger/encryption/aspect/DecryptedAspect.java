package com.example.messenger.encryption.aspect;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class DecryptedAspect {
    private final EncryptionService encryptionService;

    @Around(value = "@annotation(com.example.messenger.encryption.annotation.Decrypted)")
    private Object decryptionValueCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Object response = joinPoint.proceed();
        return encryptionService.decrypt(response.toString());
    }
}
