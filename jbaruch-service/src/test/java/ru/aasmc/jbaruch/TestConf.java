package ru.aasmc.jbaruch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@Slf4j
public class TestConf {
    @PostConstruct
    public void init(){
        log.info("NOTAFROG2");
    }

    @Bean(name = "test.string")
    public String string() {
        return "DSDSA";
    }
}
