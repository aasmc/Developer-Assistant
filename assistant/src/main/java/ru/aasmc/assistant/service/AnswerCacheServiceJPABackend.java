package ru.aasmc.assistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.help.QuestionAnswerHelper;
import ru.aasmc.assistant.persistence.AnswerEntity;
import ru.aasmc.assistant.persistence.AnswersRepository;
import ru.aasmc.assistant.persistence.QuestionEntity;
import ru.aasmc.assistant.persistence.QuestionRepository;

import java.util.Optional;

import static ru.aasmc.assistant.help.QuestionAnswerHelper.mapToAnswer;
import static ru.aasmc.assistant.help.QuestionAnswerHelper.mapToAnswerEntity;

@Service
@RequiredArgsConstructor
public class AnswerCacheServiceJPABackend implements AnswerCacheService {
    private final QuestionRepository questionRepository;
    private final AnswersRepository answersRepository;

    @Override
    public Answer find(Question question) {
        try {
            QuestionEntity questionEntity = questionRepository.findFirstByText(question.getBody());
            if (questionEntity != null) {
                return mapToAnswer(questionEntity);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void put(Long questionId, Answer answer) {
        AnswerEntity persistedAnswer = answersRepository.save(mapToAnswerEntity(answer));
        questionRepository.setAnswerFor(persistedAnswer, questionId);
    }

    @Override
    public Optional<Question> put(Question question) {
        QuestionEntity questionEntity = QuestionEntity.builder()
                .id(question.getId())
                .text(question.getBody())
                .questionType(question.getQuestionType())
                .userId(question.getUserId())
                .build();
        return Optional.ofNullable(questionRepository.save(questionEntity))
                .map(QuestionAnswerHelper::mapToQuestion);
    }

}

