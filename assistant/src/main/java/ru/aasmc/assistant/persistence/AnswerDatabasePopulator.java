package ru.aasmc.assistant.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.aasmc.assistant.AssistantProperties;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component(AnswerDatabasePopulator.DATABASE_ANSWER_POPULATOR)
public class AnswerDatabasePopulator {

    public static final String DATABASE_ANSWER_POPULATOR = "database.answer.populator";
    private final AnswersRepository answersRepository;
    private final AssistantProperties assistantProperties;

    @PostConstruct
    public void init() {
        answersRepository.saveAll(
                assistantProperties.getAnswers().stream().map(s -> AnswerEntity.builder()
                        .text(s)
                        .build()).collect(Collectors.toList())
        );
    }
}
