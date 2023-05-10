package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.AgentService;
import org.example.service.FactionsService;
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

    @PostMapping("/start")
    public ResponseEntity<String> postNewAgent(@RequestBody Map<String, Object> input) {
        ResponseEntity<String> response = null;

        log.info("{}", input);

        return response;
    }

    @GetMapping("/agent")
    public ResponseEntity<Map<String, Object>> getAgentDetails() {
        Map<String, Object> data = agentService.getAgentData();
        return ResponseEntity.of(Optional.ofNullable(data));
    }

    @GetMapping("/factions")
    public ResponseEntity<Map<String, Object>> getFactions() {
        Map<String, Object> data = factionsService.listFactions();
        return ResponseEntity.of(Optional.ofNullable(data));
    }
}
