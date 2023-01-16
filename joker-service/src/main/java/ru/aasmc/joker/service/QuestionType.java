package ru.aasmc.joker.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum QuestionType {
    JOKER(false), JBARUCH(true), OTHER(true);

    private final boolean cacheable;
}
