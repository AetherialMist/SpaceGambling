package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.config.Constants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/getting-started")
public class StartingController {

    private final RestTemplate jsonRestTemplate;

    public StartingController(@Qualifier("jsonRestTemplate") RestTemplate jsonRestTemplate) {
        this.jsonRestTemplate = jsonRestTemplate;
    }


    @PostMapping("/start")
    public ResponseEntity<String> postNewAgent(@RequestBody Map<String, Object> input) {
        ResponseEntity<String> response = null;

        log.info("{}", input);

        return response;
    }

    @GetMapping("/agent")
    public ResponseEntity<Map<String, Object>> getAgentDetails() {
        RequestEntity<Void> request = RequestEntity.get("https://api.spacetraders.io/v2/my/agent").build();
        ResponseEntity<Map<String, Object>> response = jsonRestTemplate.exchange(request, Constants.MAP_TYPE_REFERENCE);
        return response;
    }
}
