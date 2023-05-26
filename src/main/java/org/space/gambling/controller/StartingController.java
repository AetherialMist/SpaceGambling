package org.space.gambling.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.space.gambling.exception.SpaceTradersApiException;
import org.space.gambling.service.AgentService;
import org.space.gambling.service.FactionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/getting-started")
@RequiredArgsConstructor
public class StartingController {

    private final AgentService agentService;
    private final FactionsService factionsService;

    @GetMapping("/agent")
    public ResponseEntity<Map<String, Object>> getAgentDetails() {
        return invoke(agentService::getAgentData);
    }

    @GetMapping("/factions")
    public ResponseEntity<Map<String, Object>> getFactions() {
        return invoke(factionsService::listFactions);
    }

    private ResponseEntity<Map<String, Object>> invoke(ApiCall method) {
        Map<String, Object> data = null;
        try {
            data = method.invoke();
        } catch (SpaceTradersApiException e) {
            log.error("API failure.", e);
        }
        return ResponseEntity.of(Optional.ofNullable(data));
    }

    private interface ApiCall {
        Map<String, Object> invoke() throws SpaceTradersApiException;
    }
}
