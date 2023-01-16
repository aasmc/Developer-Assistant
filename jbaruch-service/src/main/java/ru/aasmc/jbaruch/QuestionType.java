package ru.aasmc.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestionType {
    JOKER(false), JBARUCH(true), OTHER(true);

    private final boolean cacheable;
}
