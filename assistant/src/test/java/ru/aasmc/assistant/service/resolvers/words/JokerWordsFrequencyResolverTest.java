package ru.aasmc.assistant.service.resolvers.words;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.service.resolvers.CommonConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextHierarchy(
        {
                @ContextConfiguration(classes = CommonConfig.class),
                @ContextConfiguration(classes = JokerWordsFrequencyResolverConfig.class)
        }
)
@ActiveProfiles("joker_vs_jbaruch")
class JokerWordsFrequencyResolverTest {
    @Autowired
    JokerWordsFrequencyResolver jokerWordsFrequencyResolver;

    @Test
    void should_work() {
        jokerWordsFrequencyResolver.setAnswers("groovy");
        int match = jokerWordsFrequencyResolver.match(Question.builder().body("groovy is..").build());
        assertEquals(1, match);
    }
}