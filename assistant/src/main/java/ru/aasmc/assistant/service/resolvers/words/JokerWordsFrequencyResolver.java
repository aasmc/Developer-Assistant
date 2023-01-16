package ru.aasmc.assistant.service.resolvers.words;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.common.utils.WordsComposer;

import static lombok.AccessLevel.PACKAGE;
import static ru.aasmc.assistant.domain.QuestionType.JOKER;

@Component
public class JokerWordsFrequencyResolver extends AbstractWordsFrequencyResolver {
    @Getter
    @Setter(PACKAGE)
    @Value("${tokens.joker}")
    private String answers;

    public JokerWordsFrequencyResolver(WordsComposer wordsComposer) {
        super(wordsComposer);
    }

    @Override
    public QuestionType getQuestionType() {
        return JOKER;
    }
}

