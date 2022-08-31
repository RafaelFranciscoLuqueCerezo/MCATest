package com.example.mcatest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class SimilarProductsAsyncConfig {
    @Bean(name = "asyncExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //CPU logic min threads that are going to be used
        executor.setCorePoolSize(2);
        //Additional threads to create when al core threads are busy
        executor.setMaxPoolSize(2147483647);
        executor.setQueueCapacity(2147483647);
        executor.setThreadNamePrefix("AsyncThreadSimilarProduct-");
        executor.initialize();
        return executor;
    }
}
