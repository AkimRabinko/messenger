package com.example.messenger.encryption.aspect;

import com.example.messenger.encryption.annotation.Encrypted;
import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptedAspect {
    private final EncryptionService encodingService;

    @Around(value = "@annotation(encrypted)")
    private Object traceMethodCall(ProceedingJoinPoint joinPoint, Encrypted encrypted) throws Throwable {
        Object response = joinPoint.proceed();
        return encodingService.encrypt(response.toString());
    }
}
