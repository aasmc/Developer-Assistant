package ru.aasmc.joker.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Answer {
    String id;
    String operatorId;
    String answer;

    String questionId;
}
