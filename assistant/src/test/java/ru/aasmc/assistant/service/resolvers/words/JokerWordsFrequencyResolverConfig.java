package ru.aasmc.assistant.service.resolvers.words;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.aasmc.common.utils.WordsComposer;

@TestConfiguration
public class JokerWordsFrequencyResolverConfig {

    @Bean
    public JokerWordsFrequencyResolver jokerWordsFrequencyResolver(WordsComposer composer) {
        return new JokerWordsFrequencyResolver(composer);
    }
}
