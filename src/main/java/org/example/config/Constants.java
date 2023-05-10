package org.example.config;

import org.springframework.core.ParameterizedTypeReference;

import java.util.Map;

public final class Constants {

    public static final ParameterizedTypeReference<Map<String, Object>> MAP_TYPE_REFERENCE = new ParameterizedTypeReference<>() {};

    public static final String SPACE_TRADERS_API_V2 = "https://api.spacetraders.io/v2";

    private Constants() {}

    public static String prefixUri(String uri) {
        return SPACE_TRADERS_API_V2 + uri;
    }

}
