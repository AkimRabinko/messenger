package com.example.messenger.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    OFFLINE(0),
    ONLINE(1);

    private int value;
}
