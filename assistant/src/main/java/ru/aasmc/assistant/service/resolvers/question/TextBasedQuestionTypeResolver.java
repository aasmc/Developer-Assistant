package ru.aasmc.assistant.service.resolvers.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.assistant.service.resolvers.words.WordsFrequencyResolver;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextBasedQuestionTypeResolver implements QuestionTypeResolver {
    private final List<WordsFrequencyResolver> wordsFrequencyResolvers;


    @Override
    public QuestionType resolveType(Question question) {
        int maxMatches = 0;
        int winnerPosition = -1;
        for (int i = 0; i < wordsFrequencyResolvers.size(); i++) {
            WordsFrequencyResolver res = wordsFrequencyResolvers.get(i);
            int match = res.match(question);
            if (match > maxMatches) {
                maxMatches = match;
                winnerPosition = i;
            }
        }
        if (maxMatches > 0) {
            return wordsFrequencyResolvers.get(winnerPosition).getQuestionType();
        }
        return QuestionType.OTHER;
    }
}
