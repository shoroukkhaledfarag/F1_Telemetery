package com.shoroukkhaled.F1_Telemetery.shared.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TelemetryConsumer {

    @KafkaListener(topics = "car-telemetry-topic", groupId = "telemetry-group")
    public void consume(String message) {
        System.out.println("Received telemetry: " + message);
    }
}
