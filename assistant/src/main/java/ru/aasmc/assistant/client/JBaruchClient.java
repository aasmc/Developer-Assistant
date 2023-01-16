package ru.aasmc.assistant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.aasmc.assistant.domain.Answer;
import ru.aasmc.assistant.domain.Question;
import ru.aasmc.assistant.domain.QuestionType;
import ru.aasmc.assistant.service.AssistantService;

@FeignClient(name = "jbaruch-service", url = "${conference.jbaruch.url}")
public interface JBaruchClient extends AssistantService {
    @Override
    @RequestMapping(path = "/question", method = RequestMethod.POST)
    Answer handleQuestion(Question question);

    @Override
    default QuestionType assistantName() {
        return QuestionType.JBARUCH;
    }
}
