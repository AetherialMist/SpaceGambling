package org.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final MapRestTemplate mapRestTemplate;

    public Map<String, Object> getAgentData() {
        return mapRestTemplate.get("https://api.spacetraders.io/v2/my/agent");
    }

}
