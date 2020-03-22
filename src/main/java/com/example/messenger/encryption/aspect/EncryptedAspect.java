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
        return joinPoint.proceed(proceedArgs(args));
    }

    private Object[] proceedArgs(Object[] args) {
        Object[] argsParsed = new Object[args.length];
        for (int i = INTEGER_ZERO; i < args.length; i++) {
            if (i == INTEGER_ZERO) {
                argsParsed[i] = encodingService.encrypt(args[i].toString());
            } else {
                argsParsed[i] = args[i];
            }
        }
        return argsParsed;
    }
}
