package org.example.service;

import org.example.config.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.example.config.SpaceConfig.JSON_REST_TEMPLATE_BEAN;

@Service
public class AgentService {

    private final RestTemplate jsonRestTemplate;

    public AgentService(@Qualifier(JSON_REST_TEMPLATE_BEAN) RestTemplate jsonRestTemplate) {
        this.jsonRestTemplate = jsonRestTemplate;
    }

    public Map<String, Object> getAgentData() {
        RequestEntity<Void> request = RequestEntity.get("https://api.spacetraders.io/v2/my/agent").build();
        ResponseEntity<Map<String, Object>> response = jsonRestTemplate.exchange(request, Constants.MAP_TYPE_REFERENCE);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new RuntimeException("oops");
    }

}
