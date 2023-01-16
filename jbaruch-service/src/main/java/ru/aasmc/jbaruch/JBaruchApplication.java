package ru.aasmc.jbaruch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(JBaruchProperties.class)
public class JBaruchApplication {
    public static void main(String[] args) {
        SpringApplication.run(JBaruchApplication.class, args);
    }
}
