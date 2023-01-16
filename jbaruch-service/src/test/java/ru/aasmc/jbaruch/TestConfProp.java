package ru.aasmc.jbaruch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@Slf4j
//@TestConfiguration
public class TestConfProp {

    @PostConstruct
    public void init(){
        log.info("NOTAFROG");
    }

    @Bean(name = "test.string")
    public String string() {
        return "DSDSA";
    }

}