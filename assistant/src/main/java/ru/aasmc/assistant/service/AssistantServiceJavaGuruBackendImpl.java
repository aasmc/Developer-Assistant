package ru.aasmc.assistant.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("composite.assistant")
@RequiredArgsConstructor
public class AssistantServiceJavaGuruBackendImpl implements AssistantServiceJavaGuruBackend {
    private final AnswerCacheService answerCacheService;
    private Map<QuestionType, AssistantService> questionTypeAssistantMap = new HashMap<>();

    @Autowired
    private void initMap(List<AssistantService> assistantServiceList) {
        assistantServiceList.forEach(assistantService -> {
            QuestionType assistantName = assistantService.assistantName();
            if (questionTypeAssistantMap.containsKey(assistantName)) {
                throw new IllegalStateException("duplicate handle of " + assistantName);
            }
            questionTypeAssistantMap.put(assistantName, assistantService);
        });
    }

    @Override
    public Answer handleQuestion(Question question) {
        // only for jbaruch
        if (question.getQuestionType().isCacheable()) {
            Answer answer = answerCacheService.find(question);
            if (answer != null && answer.getAnswer() != null) {
                return answer;
            }
            if (question.getId() == null) {
                Long id = answerCacheService.put(question)
                        .orElse(Question.builder().build()).getId();
                question.setId(id);
            }
        }
        AssistantService assistantService = questionTypeAssistantMap.get(question.getQuestionType());
        if (assistantService == null) {
            throw new UnsupportedOperationException("Not implemented yet");
        }
        return assistantService.handleQuestion(question);
    }
}
