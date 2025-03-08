package com.shoroukkhaled.F1_Telemetery.shared.infrastructure.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoroukkhaled.F1_Telemetery.modules.telemetry.entities.CarTelemetry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TelemetryProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Random random = new Random();

    public TelemetryProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000) // Send data every 2 seconds
    public void sendTelemetry() {
        try {
            CarTelemetry telemetry = new CarTelemetry(
                    1, // Car ID
                    System.currentTimeMillis(),
                    random.nextDouble() * 300,  // Speed (0 - 300 km/h)
                    6000 + random.nextInt(4000), // RPM (6000 - 10000)
                    30 + random.nextDouble() * 5, // Tire Pressure (30 - 35 PSI)
                    50 + random.nextDouble() * 50, // Fuel Level (50 - 100%)
                    80 + random.nextDouble() * 20, // Engine Temp (80 - 100°C)
                    12 + random.nextDouble() * 2, // Battery Voltage (12 - 14V)
                    40.7128 + random.nextDouble(),
                    -74.0060 + random.nextDouble()
            );

            String message = objectMapper.writeValueAsString(telemetry);
            kafkaTemplate.send("car-telemetry-topic", message);
            System.out.println("Sent telemetry: " + message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}