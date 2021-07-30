package com.example.demo.kafkaService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics="mytopic", groupId="test-consumer-group")
    public void consumeFromTopic(String message) {
        System.out.println("Consummed message "+ message);
    }

}
