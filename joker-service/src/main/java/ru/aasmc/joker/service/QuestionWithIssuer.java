package ru.aasmc.joker.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class QuestionWithIssuer {
    private final Question question;
    private final Issuer issuer;
}