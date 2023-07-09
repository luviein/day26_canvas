package com.example.day26_canvas.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

public class OpenAPIConfig {
    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI().info(new Info()
        .title("PAF Day 26 Workshop")
        .description("Getting Boardgame query")
        .version("version 1.0"));

    }
}
