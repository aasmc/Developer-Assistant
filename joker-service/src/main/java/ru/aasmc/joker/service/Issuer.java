package ru.aasmc.joker.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Issuer {
    private final String name;
}
