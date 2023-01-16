package ru.aasmc.assistant.service.resolvers.words;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.common.utils.WordsComposer;

@Component
public class JBaruchWordsFrequencyResolver extends AbstractWordsFrequencyResolver {

    @Getter
    @Value("${tokens.jbaruch}")
    private String answers;

    public JBaruchWordsFrequencyResolver(WordsComposer wordsComposer) {
        super(wordsComposer);
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.JBARUCH;
    }
}
