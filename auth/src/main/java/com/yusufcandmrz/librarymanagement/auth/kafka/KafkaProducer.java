package com.yusufcandmrz.librarymanagement.auth.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRegisteredEvent(String message) {
        String topic = "auth.topics";
        kafkaTemplate.send(topic, message);
    }
}
