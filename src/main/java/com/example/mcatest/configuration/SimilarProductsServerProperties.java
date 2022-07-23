package com.example.mcatest.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.microservices")
public class SimilarProductsServerProperties {
    private String mcaMicroservice;
}
