package ru.aasmc.assistant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestionType {
    JOKER(false), JBARUCH(true), OTHER(true);

    private final boolean cacheable;
}
