package ru.aasmc.joker;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "joker")
public class JokerProperties {
    List<String> answers;
}
