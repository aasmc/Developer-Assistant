package ru.aasmc.assistant.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DeveloperAssistantApplicationTests {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(applicationContext);
    }

}
