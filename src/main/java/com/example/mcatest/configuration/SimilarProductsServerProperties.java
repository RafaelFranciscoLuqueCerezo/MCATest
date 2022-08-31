package com.example.mcatest.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class SimilarProductsServerProperties {
    private String mcaMicroservice;
    private List<String> corsOrigins;
}
