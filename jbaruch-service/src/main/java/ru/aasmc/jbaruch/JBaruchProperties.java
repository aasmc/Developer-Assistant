package ru.aasmc.jbaruch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "jbaruch")
public class JBaruchProperties {
    private List<String> answers;
}
