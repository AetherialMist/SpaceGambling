package org.example.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.rest.MapRestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties(SpaceProperties.class)
public class SpaceConfig {

    public static final String JSON_REST_TEMPLATE_BEAN = "jsonRestTemplate";

    public SpaceConfig() {
        log.info("Hello World.");
    }

    @Bean(JSON_REST_TEMPLATE_BEAN)
    public RestTemplate jsonRestTemplate(SpaceProperties props) {
        RestTemplate template = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(createAuthInterceptor(props));
        template.setInterceptors(interceptors);
        return template;
    }

    @Bean
    public MapRestTemplate mapRestTemplate(@Qualifier(JSON_REST_TEMPLATE_BEAN) RestTemplate template) {
        return new MapRestTemplate(template);
    }

    private ClientHttpRequestInterceptor createAuthInterceptor(SpaceProperties props) {
        return (request, body, execution) -> {
            request.getHeaders().set("Authorization", "Bearer " + props.getToken());
            request.getHeaders().set("Accept", MediaType.APPLICATION_JSON_VALUE);
            return execution.execute(request, body);
        };
    }

}
