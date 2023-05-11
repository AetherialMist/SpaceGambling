package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("space-traders")
public class SpaceTradersProperties {

    private String host;
    private String version;

}
