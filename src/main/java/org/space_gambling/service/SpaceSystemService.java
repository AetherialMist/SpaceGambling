package org.space_gambling.service;

import lombok.RequiredArgsConstructor;
import org.space_gambling.exception.SpaceTradersApiException;
import org.space_gambling.rest.SpaceTradersRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpaceSystemService {

    private final SpaceTradersRestTemplate spaceTradersRestTemplate;

    public Map<String, Object> getSystemInformation(String system, String waypoint) throws SpaceTradersApiException {
        String path = String.format("/systems/%s/waypoints/%s", system, waypoint);
        return spaceTradersRestTemplate.invoke(HttpMethod.GET, path);
    }

}
