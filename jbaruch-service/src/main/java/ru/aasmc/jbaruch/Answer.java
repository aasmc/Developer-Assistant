package ru.aasmc.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Answer {
    private String id;
    private String operatorId;
    private String answer;

    private String questionId;
}
