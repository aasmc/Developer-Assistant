package ru.aasmc.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private String id;
    private String userId;
    private String body;

    private QuestionType questionType;
}
