package org.example.service;

import org.example.config.Constants;
import org.example.rest.MapRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FactionsService {

    private final MapRestTemplate mapRestTemplate;

    public FactionsService(MapRestTemplate mapRestTemplate) {
        this.mapRestTemplate = mapRestTemplate;
    }

    public Map<String, Object> listFactions() {
        return mapRestTemplate.get(Constants.prefixUri("/factions"));
    }

}
