package ru.aasmc.assistant.service;

import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;

import java.util.Optional;

/**
 * Если вопрос уже задавали Баруху - не отправляем,
 * он человек слова, не передумает. Поэтому у баруха нет очереди,
 * но есть кэш
 *  А Joker отправляем всегда, он может передумать,
 *  он всегда в поисках истины. Есть очередь но нет кэша
 */
public interface AnswerCacheService {
    Answer find(Question question);

    void put(Long questionId, Answer answer);

    Optional<Question> put(Question question);
}
