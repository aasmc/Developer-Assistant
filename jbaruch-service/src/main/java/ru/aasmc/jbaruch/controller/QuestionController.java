package ru.aasmc.jbaruch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.aasmc.jbaruch.AnswerResponse;
import ru.aasmc.jbaruch.FastAndTruthService;
import ru.aasmc.jbaruch.QuestionRequest;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final FastAndTruthService fastAndTruthService;

    @PostConstruct
    public void init() {
        System.out.println("fastAndTruthService = " + fastAndTruthService);
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public AnswerResponse handleQuestion(@RequestBody QuestionRequest question) {
        return AnswerResponse.builder()
                .answer(fastAndTruthService.handleQuestion(question))
                .build();
    }
}
