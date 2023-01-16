package ru.aasmc.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.aasmc.common.utils.AnswerComposer;
import ru.aasmc.common.utils.WordsComposer;

@Configuration
@PropertySource("classpath:user.properties")
public class GarbageAutoConfiguration {

    @Bean
    GarbageProperties garbageProperties(){
        return new GarbageProperties();
    }

    @Bean
    WordsComposer wordsComposer(GarbageProperties garbageProperties) {
        return new WordsComposer(garbageProperties);
    }

    @Bean
    AnswerComposer answerComposer(GarbageProperties garbageProperties) {
        return new AnswerComposer(wordsComposer(garbageProperties));
    }

}
