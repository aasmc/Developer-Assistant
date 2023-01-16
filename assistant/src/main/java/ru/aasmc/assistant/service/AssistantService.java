package ru.aasmc.assistant.service;

import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;

public interface AssistantService {
    Answer handleQuestion(Question question);
    QuestionType assistantName();
}
