package com.example.mcatest.configuration;

import com.example.mcatest.application.common.RestTemplateErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateErrorHandler restTemplateErrorHandler;
    @Value("${restTemplateReadTimeout}")
    private String readTimeout;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .setReadTimeout(Duration.ofSeconds(Long.parseLong(readTimeout)))
                .errorHandler(restTemplateErrorHandler)
                .build();
    }
}
