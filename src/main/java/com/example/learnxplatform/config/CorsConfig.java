package com.example.learnxplatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    // Define a bean to configure CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration(); // Create a new CorsConfiguration object
        configuration.addAllowedOrigin("http://localhost:3000"); // Allow requests from this origin
        configuration.addAllowedMethod("*"); // Allow all HTTP methods
        configuration.addAllowedHeader("*"); // Allow all headers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // Register the CorsConfiguration for all paths
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
