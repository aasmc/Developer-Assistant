package ru.aasmc.joker;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.aasmc.joker.service.Question;
import ru.aasmc.joker.service.SlowRecommendationService;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final SlowRecommendationService slowRecommendationService;

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public ResponseEntity handleQuestion(@RequestBody Question question) {
        slowRecommendationService.addQuestion(question);
        return ResponseEntity.ok().build();
    }
}
