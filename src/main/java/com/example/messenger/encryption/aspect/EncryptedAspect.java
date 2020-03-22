package com.example.messenger.encryption.aspect;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptedAspect {
    private final EncryptionService encodingService;

    @Around(value = "@annotation(com.example.messenger.encryption.annotation.Encrypted)")
    private Object encryptionValueCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        return joinPoint.proceed(encryptArgs(args));
    }

    private Object[] encryptArgs(Object[] args) {
        Object[] argsEncrypted = new Object[args.length];
        for (int i = INTEGER_ZERO; i < args.length; i++) {
            if (i == INTEGER_ZERO) {
                argsEncrypted[i] = encodingService.encrypt(args[i].toString());
            } else {
                argsEncrypted[i] = args[i];
            }
        }
        return argsEncrypted;
    }
}
