package ru.aasmc.assistant.service.resolvers.question;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.assistant.service.resolvers.CommonConfig;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextHierarchy(
        {
                @ContextConfiguration(classes = CommonConfig.class),
                @ContextConfiguration(classes = TextBasedQuestionTypeResolverConfig.class)
        }
)
@ActiveProfiles("joker_vs_jbaruch")
class TextBasedQuestionTypeResolverTest {
    @Autowired
    TextBasedQuestionTypeResolver textBasedQuestionTypeResolver;

    @Test
    void should_work() {
        QuestionType jbaruch = textBasedQuestionTypeResolver.resolveType(Question.builder().body("groovy").build());
        QuestionType joker = textBasedQuestionTypeResolver.resolveType(Question.builder().body("smile").build());

        assertAll(
                () -> assertEquals(QuestionType.JBARUCH, jbaruch),
                () -> assertEquals(QuestionType.JOKER, joker)
        );
    }
}