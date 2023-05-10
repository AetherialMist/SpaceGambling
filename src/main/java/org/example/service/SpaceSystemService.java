package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.config.Constants;
import org.example.rest.MapRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpaceSystemService {

    private final MapRestTemplate mapRestTemplate;

    public Map<String, Object> getSystemInformation(String system, String waypoint) {
        String path = String.format("/systems/%s/waypoints/%s", system, waypoint);
        return mapRestTemplate.get(Constants.prefixUri(path));
    }

}
