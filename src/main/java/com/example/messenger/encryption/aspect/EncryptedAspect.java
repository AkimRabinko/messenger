package com.example.messenger.encryption.aspect;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptedAspect {
    private static final int FIRST_ARGUMENT = 0;
    private final EncryptionService encodingService;

    @Around(value = "@annotation(com.example.messenger.encryption.annotation.Encrypted)")
    private Object encryptionValueCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        args[FIRST_ARGUMENT] = encodingService.encrypt(args[FIRST_ARGUMENT].toString());
        return joinPoint.proceed(args);
    }
}
