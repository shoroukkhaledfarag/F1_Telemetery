package com.shoroukkhaled.F1_Telemetery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.shoroukkhaled.F1_Telemetery.modules")
@EnableJpaRepositories(basePackages = "com.shoroukkhaled.F1_Telemetery.modules")
@ComponentScan(basePackages = {"com.shoroukkhaled.F1_Telemetery.modules","com.shoroukkhaled.F1_Telemetery.modules.team.mappers" })
@SpringBootApplication
public class F1TelemetryApplication {

        public static void main(String[] args) {
            SpringApplication.run(F1TelemetryApplication.class, args);
        }
}
