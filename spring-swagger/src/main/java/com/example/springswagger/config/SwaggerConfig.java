package com.example.springswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("custom-api")
                .packagesToScan("com.example.springswagger.controller")
                .build();
    }
}
