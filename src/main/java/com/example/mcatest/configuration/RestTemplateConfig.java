package com.example.mcatest.configuration;

import com.example.mcatest.application.common.RestTemplateErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateErrorHandler restTemplateErrorHandler;
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(restTemplateErrorHandler);
        return restTemplate;
    }
}
