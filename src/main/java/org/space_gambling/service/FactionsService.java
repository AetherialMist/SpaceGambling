package org.space_gambling.service;

import org.space_gambling.exception.SpaceTradersApiException;
import org.space_gambling.rest.SpaceTradersRestTemplate;
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
