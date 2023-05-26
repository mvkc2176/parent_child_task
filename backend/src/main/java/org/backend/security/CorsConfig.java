package org.backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {
    
    // Define a bean for CorsFilter with allowedOrigins as a parameter
    @Bean
    public CorsFilter corsFilter(@Value("${app.cors.allowed-origins}") List<String> allowedOrigins) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Set whether the browser should include credentials (e.g., cookies) in CORS requests
        config.setAllowCredentials(true);
        
        // Set the allowed origins from the configuration parameter
        config.setAllowedOriginPatterns(allowedOrigins);
        
        // Allow all HTTP methods (e.g., GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");
        
        // Allow all headers in CORS requests
        config.addAllowedHeader("*");
        
        // Register the CORS configuration for all URL paths
        source.registerCorsConfiguration("/**", config);
        
        // Create and return a new CorsFilter instance with the configured source
        return new CorsFilter(source);
    }
}
