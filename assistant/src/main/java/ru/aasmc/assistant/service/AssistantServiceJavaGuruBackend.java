package ru.aasmc.assistant.service;

import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;

public interface AssistantServiceJavaGuruBackend {
    Answer handleQuestion(Question question);
}
