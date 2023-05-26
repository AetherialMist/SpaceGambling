package org.space.gambling.rest;

import lombok.extern.slf4j.Slf4j;
import org.space.gambling.config.Constants;
import org.space.gambling.config.SpaceTradersProperties;
import org.space.gambling.exception.SpaceTradersApiException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

import static org.space.gambling.config.SpaceTradersConfig.JSON_WITH_AUTH_REST_TEMPLATE_BEAN;

@Slf4j
@Service
public class SpaceTradersRestTemplate {

    private final RestTemplate restTemplate;
    private final String baseUri;

    public SpaceTradersRestTemplate(@Qualifier(JSON_WITH_AUTH_REST_TEMPLATE_BEAN) final RestTemplate restTemplate, final SpaceTradersProperties properties) {
        this.restTemplate = restTemplate;
        this.baseUri = String.format("%s/%s", properties.getHost(), properties.getVersion());
    }

    public Map<String, Object> invoke(HttpMethod method, String path) throws SpaceTradersApiException {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        return exchange(new RequestEntity<>(method, URI.create(String.format("%s/%s", baseUri, path))));
    }

    private Map<String, Object> exchange(RequestEntity<Void> request) throws SpaceTradersApiException {
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(request, Constants.MAP_TYPE_REFERENCE);
        String uri = request.getUrl().toString();
        HttpMethod httpMethod = request.getMethod();
        String method = Objects.nonNull(httpMethod) ? httpMethod.toString() : "UNKNOWN";

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Successful {} request to [{}]", method, uri);
            return response.getBody();
        }

        log.info("Failed {} request to [{}] with status [{}]",method, uri, response.getStatusCode());
        throw new SpaceTradersApiException("Request Failed");
    }

}
