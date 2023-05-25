package org.space_gambling.service;

import lombok.RequiredArgsConstructor;
import org.space_gambling.exception.SpaceTradersApiException;
import org.space_gambling.rest.SpaceTradersRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final SpaceTradersRestTemplate spaceTradersRestTemplate;

    public Map<String, Object> getAgentData() throws SpaceTradersApiException {
        return spaceTradersRestTemplate.invoke(HttpMethod.GET, "/my/agent");
    }

}
