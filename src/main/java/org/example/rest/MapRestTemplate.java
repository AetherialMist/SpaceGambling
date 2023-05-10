package org.example.rest;

import org.example.config.Constants;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class MapRestTemplate {

    private final RestTemplate jsonRestTemplate;

    public MapRestTemplate(RestTemplate jsonRestTemplate) {
        this.jsonRestTemplate = jsonRestTemplate;
    }

    public Map<String, Object> get(String uri) {
        RequestEntity<Void> request = RequestEntity.get(uri).build();
        ResponseEntity<Map<String, Object>> response = jsonRestTemplate.exchange(request, Constants.MAP_TYPE_REFERENCE);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new RuntimeException("oops");
    }

}
