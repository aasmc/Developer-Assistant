package ru.aasmc.assistant.service.resolvers.question;

import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;

public interface QuestionTypeResolver {
    QuestionType resolveType(Question question);
}
