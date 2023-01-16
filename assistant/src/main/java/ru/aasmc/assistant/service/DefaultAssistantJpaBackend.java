package ru.aasmc.assistant.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.assistant.persistence.AnswerDatabasePopulator;
import ru.aasmc.assistant.persistence.AnswerEntity;
import ru.aasmc.assistant.persistence.AnswersRepository;
import ru.aasmc.common.utils.IconConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@DependsOn(AnswerDatabasePopulator.DATABASE_ANSWER_POPULATOR)
public class DefaultAssistantJpaBackend implements AssistantService {
    private final AnswersRepository answersRepository;
    private final List<Answer> answers;

    public DefaultAssistantJpaBackend(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
        answers = new ArrayList<>();
        Iterable<AnswerEntity> all = answersRepository.findAll();
        for (AnswerEntity answerEntity : all) {
            answers.add(Answer.builder()
                    .answer(answerEntity.getText())
                    .operatorId(IconConstants.SKULL_ICON)
                    .id(answerEntity.getId())
                    .build());
        }
    }

    @Override
    public Answer handleQuestion(Question question) {
        return getRandomAnswer();
    }

    @Override
    public QuestionType assistantName() {
        return QuestionType.OTHER;
    }

    private Answer getRandomAnswer() {
        int randomAnswerIndex = ThreadLocalRandom.current().nextInt(answers.size());
        return answers.get(randomAnswerIndex);
    }

}
