package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.service.TokenService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Configuration
@EnableConfigurationProperties(SpaceTradersProperties.class)
public class SpaceTradersConfig {

    public static final String JSON_WITH_AUTH_REST_TEMPLATE_BEAN = "jsonRestTemplate";

    @Bean(JSON_WITH_AUTH_REST_TEMPLATE_BEAN)
    public RestTemplate jsonWithAuthRestTemplate(List<ClientHttpRequestInterceptor> interceptors) {
        RestTemplate template = new RestTemplate();
        template.setInterceptors(interceptors);
        return template;
    }

    @Bean
    public ClientHttpRequestInterceptor bearerAuthInterceptor(final TokenService tokenService) {
        return (request, body, execution) -> {
            request.getHeaders().set("Authorization", "Bearer " + tokenService.getAuthToken());
            // Executes the next Interceptor if one exists, otherwise executes the HTTP request.
            return execution.execute(request, body);
        };
    }

    @Bean
    public ClientHttpRequestInterceptor acceptJsonInterceptor() {
        return (request, body, execution) -> {
            request.getHeaders().set("Accept", MediaType.APPLICATION_JSON_VALUE);
            // Executes the next Interceptor if one exists, otherwise executes the HTTP request.
            return execution.execute(request, body);
        };
    }

}
