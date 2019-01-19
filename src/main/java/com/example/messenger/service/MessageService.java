package com.example.messenger.service;

public interface MessageService {
    void send(String message);

    String receive();
}
