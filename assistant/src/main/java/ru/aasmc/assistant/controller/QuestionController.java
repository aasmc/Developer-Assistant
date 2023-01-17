package ru.aasmc.assistant.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.service.AssistantServiceJavaGuruBackend;
import ru.aasmc.assistant.service.NotificationService;
import ru.aasmc.assistant.service.resolvers.question.QuestionTypeResolver;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final NotificationService notificationService;
    private final AssistantServiceJavaGuruBackend assistantService;
    private final QuestionTypeResolver questionTypeResolver;

    @PostMapping("/question")
    public ResponseEntity handleQuestion(@RequestBody Question question) {
        question.setQuestionType(questionTypeResolver.resolveType(question));

        Answer answer = assistantService.handleQuestion(question);
        if (answer != null) {
            log.info("{} answer: {}", answer.getOperatorId(), answer);
            notificationService.notify(answer);
        } else {
            log.info("waiting joker answer...");
        }
        return ResponseEntity.ok("{}");
    }
}
