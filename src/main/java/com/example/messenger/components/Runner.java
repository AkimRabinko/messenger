package com.example.messenger.components;

import com.example.messenger.MessengerApplication;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.messenger.MessengerApplication.ROUTING_KEY;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(MessengerApplication.TOPIC_EXCHANGE_NAME, ROUTING_KEY, "Hello from RabbitMQ!");
        receiver.getLatch().await(5, TimeUnit.SECONDS);
    }
}
