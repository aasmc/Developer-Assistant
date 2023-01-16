package ru.aasmc.joker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(JokerProperties.class)
public class JokerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JokerApplication.class, args);
    }
}
