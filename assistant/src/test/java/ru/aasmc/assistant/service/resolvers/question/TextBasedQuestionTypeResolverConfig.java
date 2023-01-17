package ru.aasmc.assistant.service.resolvers.question;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.aasmc.assistant.service.resolvers.words.WordsFrequencyResolver;

import java.util.List;

@TestConfiguration
public class TextBasedQuestionTypeResolverConfig {

    @Bean
    public TextBasedQuestionTypeResolver textBasedQuestionTypeResolver(List<WordsFrequencyResolver> resolvers) {
        return new TextBasedQuestionTypeResolver(resolvers);
    }

}
