package com.example.messenger.encryption.aspect;

import com.example.messenger.encryption.annotation.Decrypted;
import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class DecryptedAspect {
    private final EncryptionService encryptionService;

    @Around(value = "@annotation(decrypted)")
    private Object traceMethodCall(ProceedingJoinPoint joinPoint, Decrypted decrypted) throws Throwable {
        Object response = joinPoint.proceed();
        return encryptionService.decrypt(response.toString());
    }
}
