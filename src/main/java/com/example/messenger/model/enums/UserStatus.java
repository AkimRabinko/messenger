package com.example.messenger.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    OFFLINE(0),
    ONLINE(1);

    private final int value;
}
