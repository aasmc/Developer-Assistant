package ru.aasmc.assistant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.persistence.AnswersRepository;
import ru.aasmc.assistant.persistence.QuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("joker_vs_jbaruch")
class AnswerCacheServiceJPABackendTest {

    @Autowired
    AnswerCacheServiceJPABackend answerCacheServiceJPABackend;

    @MockBean
    QuestionRepository questionRepository;
    @MockBean
    AnswersRepository answersRepository;

    @Test
    void should_work() {
        when(questionRepository.findFirstByText(anyString()))
                .thenThrow(new RuntimeException());
        Answer sth = answerCacheServiceJPABackend.find(Question.builder().body("sth").build());
        assertNull(sth);
    }
}