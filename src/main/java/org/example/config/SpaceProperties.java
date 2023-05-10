package org.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("space")
public class SpaceProperties {
    
    private String token;

}
