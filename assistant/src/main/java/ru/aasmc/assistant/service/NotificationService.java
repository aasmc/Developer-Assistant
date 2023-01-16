package ru.aasmc.assistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ru.aasmc.assistant.domain.Answer;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final AnswerCacheService answerCacheService;
    private Deque<SseEmitter> emitters = new ConcurrentLinkedDeque<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

    public boolean addEmitter(SseEmitter sseEmitter) {
        return emitters.add(sseEmitter);
    }

    public boolean removeEmitter(SseEmitter sseEmitter) {
        return emitters.remove(sseEmitter);
    }

    public void notify(Answer answer) {
        setDateIfNotExists(answer);
        if (answer.getQuestionId() != null) {
            try {
                answerCacheService.put(answer.getQuestionId(), answer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setDateIfNotExists(Answer answer) {
        if (answer.getAnswerDate() == null) {
            answer.setAnswerDate(ZonedDateTime.now().format(formatter));
        }
    }
}
