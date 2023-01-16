package ru.aasmc.assistant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private long id;
    private String operatorId;
    private String answer;
    private String answerDate;

    private Long questionId;
}
