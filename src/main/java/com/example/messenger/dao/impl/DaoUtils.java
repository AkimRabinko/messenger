package com.example.messenger.dao.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class DaoUtils {
    static boolean isUpdated(int result) {
        return result > 0;
    }
}
