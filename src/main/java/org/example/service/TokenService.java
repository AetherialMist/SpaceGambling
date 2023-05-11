package org.example.service;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TokenService {

    public static final String AUTH_TOKEN_ENV_VAR = "TOKEN";

    private final Dotenv dotenv;
    private final String authToken;

    public TokenService() {
        dotenv = Dotenv.load();
        authToken = getAuthBearerTokenFromEnv();
    }

    public String getAuthToken() {
        return authToken;
    }

    private String getAuthBearerTokenFromEnv() {
        String token = dotenv.get(AUTH_TOKEN_ENV_VAR);
        String lastCharacters = token.substring(token.length() - 6);
        log.debug("Using auth token ending in [{}]", lastCharacters);
        return token;
    }
}
