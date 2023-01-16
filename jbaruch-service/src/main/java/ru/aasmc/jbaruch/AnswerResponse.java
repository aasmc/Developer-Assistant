package ru.aasmc.jbaruch;

import lombok.Builder;
import lombok.experimental.Delegate;

@Builder
public class AnswerResponse {
    @Delegate Answer answer;
}
