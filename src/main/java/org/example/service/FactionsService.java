package org.example.service;

import org.example.exception.SpaceTradersApiException;
import org.example.rest.SpaceTradersRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FactionsService {

    private final SpaceTradersRestTemplate spaceTradersRestTemplate;

    public FactionsService(SpaceTradersRestTemplate spaceTradersRestTemplate) {
        this.spaceTradersRestTemplate = spaceTradersRestTemplate;
    }

    public Map<String, Object> listFactions() throws SpaceTradersApiException {
        return spaceTradersRestTemplate.invoke(HttpMethod.GET, "/factions");
    }

}
