package ru.aasmc.joker.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private String id;
    private String userId;
    private String body;

    private QuestionType questionType;
}
