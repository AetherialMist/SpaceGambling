package org.example.config;

import org.springframework.core.ParameterizedTypeReference;

import java.util.Map;

public final class Constants {

    public static final ParameterizedTypeReference<Map<String, Object>> MAP_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};

    private Constants() {}

}
