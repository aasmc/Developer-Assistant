package ru.aasmc.assistant.service.resolvers.words;

import lombok.RequiredArgsConstructor;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.common.utils.WordsComposer;

@RequiredArgsConstructor
public abstract class AbstractWordsFrequencyResolver implements WordsFrequencyResolver {
    private final WordsComposer wordsComposer;

    @Override
    public int match(Question question) {
        return (int) wordsComposer.extractWordsWithoutGarbage(question.getBody().toLowerCase())
                .stream()
                .filter(s -> getAnswers().contains(s))
                .count();
    }

    protected  abstract String getAnswers();
}
