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
public class FactionsService {

    private final MapRestTemplate mapRestTemplate;

    public FactionsService(MapRestTemplate mapRestTemplate) {
        this.mapRestTemplate = mapRestTemplate;
    }

    public Map<String, Object> getListOfFactions() {
        String uri = String.format("%s/factions", Constants.SPACE_TRADERS_API_V2);
        return mapRestTemplate.get(uri);
    }

}
