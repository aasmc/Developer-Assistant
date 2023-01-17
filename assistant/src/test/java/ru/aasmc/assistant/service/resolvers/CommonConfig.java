package ru.aasmc.assistant.service.resolvers;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@TestConfiguration
@ComponentScan("ru.aasmc.common")
public class CommonConfig {

    @PostConstruct
    public void init() {
        System.out.println("Connecting to DB...");
    }
}
