package com.example.messenger.encryption.service.impl;

import com.example.messenger.encryption.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncryptionServiceImpl implements EncryptionService {
    private static final int MULTIPLICITY = 16;

    private final Cipher cipherEncrypt;
    private final Cipher cipherDecrypt;

    @Override
    public String encrypt(String value) {
        try {
            byte[] encrypted = cipherEncrypt.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            log.error("Error during string encryption {}", value, e);
        }
        return value;
    }

    @Override
    public String decrypt(String value) {
        try {
            StringBuilder result = new StringBuilder();
            byte[][] decryptData = getDecryptData(Base64.decodeBase64(value));
            for (int i = 0; i < decryptData.length; i++) {
                if ((i + 1) != decryptData.length) {
                    byte[] original = cipherDecrypt.update(decryptData[i]);
                    result.append(new String(original));
                } else {
                    byte[] original = cipherDecrypt.doFinal(decryptData[i]);
                    result.append(new String(original));
                }
            }
            return result.toString();
        } catch (Exception e) {
            log.error("Error during string decrypt {}", value, e);
        }
        return value;
    }

    private byte[][] getDecryptData(byte[] arr) {
        int blocksNUmber = getBumOfBlocks(arr);
        byte[][] resultArr = new byte[blocksNUmber][MULTIPLICITY];

        for (int i = INTEGER_ZERO; i < blocksNUmber; i++) {
            int start = i * MULTIPLICITY;
            int end = (i + 1) * MULTIPLICITY;
            resultArr[i] = getArray(arr, start, end);
        }
        return resultArr;
    }

    private int getBumOfBlocks(byte[] arr) {
        int blocksNumber = arr.length / MULTIPLICITY;
        return blocksNumber == INTEGER_ZERO ? 1 : blocksNumber;
    }

    private byte[] getArray(byte[] arr, int start, int end) {
        byte[] arrPart = new byte[MULTIPLICITY];
        int length = Math.min(arr.length, end) - start;
        if (length >= 0) {
            System.arraycopy(arr, start, arrPart, start, length);
        }
        return arrPart;
    }
}
