package ru.aasmc.assistant.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ru.aasmc.assistant.domain.Answer;
import org.springframework.http.MediaType;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Slf4j
public class AnswerSender {
    private Answer answer;
    private MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;

    private AnswerSender(Answer answer) {
        this.answer = answer;
    }

    public static AnswerSender sendAnswer(Answer answer) {
        return new AnswerSender(answer);
    }

    public AnswerSender mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public void to(SseEmitter sseEmitter) {
        try {
            sseEmitter.send(answer, APPLICATION_JSON);
        } catch (IOException e) {
            log.error("Error", e);
        }
    }
}
