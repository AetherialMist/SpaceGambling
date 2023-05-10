package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.config.Constants;
import org.example.rest.MapRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final MapRestTemplate mapRestTemplate;

    public Map<String, Object> getAgentData() {
        return mapRestTemplate.get(Constants.prefixUri("/my/agent"));
    }

}
