package ru.aasmc.jbaruch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.aasmc.common.utils.AnswerComposer;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static ru.aasmc.common.utils.IconConstants.JBARUCH_ICON;

@Slf4j
@Service
@RequiredArgsConstructor
public class FastAndTruthService {
    private final JBaruchProperties jBaruchProperties;
    private final AnswerComposer answerComposer;
    private AtomicLong atomicLong = new AtomicLong();

    public Answer handleQuestion(QuestionRequest question) {
        List<String> answers = jBaruchProperties.getAnswers();

        String answerText = answerComposer.giveAnswerText(answers, question.getBody());
        return Answer.builder()
                .id(String.valueOf(atomicLong.incrementAndGet()))
                .questionId(question.getId())
                .operatorId(JBARUCH_ICON)
                .answer(answerText)
                .build();
    }
}
