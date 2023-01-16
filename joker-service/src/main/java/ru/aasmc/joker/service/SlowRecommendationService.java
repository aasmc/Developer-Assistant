package ru.aasmc.joker.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.aasmc.common.utils.AnswerComposer;
import ru.aasmc.joker.JokerProperties;
import ru.aasmc.joker.client.Answer;
import ru.aasmc.joker.client.AssistantClient;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import static ru.aasmc.common.utils.IconConstants.JOKER_ICON;



@Slf4j
@Service
@RequiredArgsConstructor
public class SlowRecommendationService {
    private final AssistantClient assistantClient;
    private final JokerProperties jokerProperties;
    private final AnswerComposer answerComposer;
    private BlockingQueue<Question> questionQueue = new ArrayBlockingQueue<>(10);
    private AtomicLong atomicLong = new AtomicLong();

    @Scheduled(cron = "*/2 * * * * ?")
    public void scheduler() {
        try {
            Question poll = questionQueue.poll();

            if (poll != null) {
                log.info("Question: {}", poll.getBody());
                log.info("Joker thinking...");
                log.info("Joker answering...");

                String answerText = answerComposer.giveAnswerText(jokerProperties.getAnswers(), poll.getBody());

                Answer answer = Answer.builder()
                        .id(String.valueOf(atomicLong.incrementAndGet()))
                        .questionId(poll.getId())
                        .operatorId(JOKER_ICON)
                        .answer(answerText)
                        .build();

                assistantClient.answer(answer);
            } else {
                log.info("Joker waiting...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateAnswer() {
        return " – yes";
    }

    public void addQuestion(Question question) {
        log.info("Add question to joker queue and wait...");
        questionQueue.add(question);
    }
}




























