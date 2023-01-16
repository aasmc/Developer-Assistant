package ru.aasmc.assistant.service.resolvers.words;

import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;

public interface WordsFrequencyResolver {
    int match(Question question);
    QuestionType getQuestionType();
}
