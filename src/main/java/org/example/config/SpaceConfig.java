package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.example.rest.MapRestTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class SpaceConfig {

    public static final String JSON_REST_TEMPLATE_BEAN = "jsonRestTemplate";

    public SpaceConfig() {
        log.info("Hello World.");
    }

    @Bean(JSON_REST_TEMPLATE_BEAN)
    public RestTemplate jsonRestTemplate() {
        RestTemplate template = new RestTemplate();
        Dotenv dotenv = Dotenv.load();

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(createAuthInterceptor(dotenv.get("TOKEN")));
        template.setInterceptors(interceptors);
        return template;
    }

    @Bean
    public MapRestTemplate mapRestTemplate(@Qualifier(JSON_REST_TEMPLATE_BEAN) RestTemplate template) {
        return new MapRestTemplate(template);
    }

    private ClientHttpRequestInterceptor createAuthInterceptor(String token) {
        return (request, body, execution) -> {
            request.getHeaders().set("Authorization", "Bearer " + token);
            request.getHeaders().set("Accept", MediaType.APPLICATION_JSON_VALUE);
            return execution.execute(request, body);
        };
    }

}
