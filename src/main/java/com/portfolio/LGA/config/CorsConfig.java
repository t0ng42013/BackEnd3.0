package com.portfolio.LGA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsCongigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login")
                        .allowedOrigins("http://localhost:4200", "https://portfolio3-2.onrender.com")
                        .allowedMethods("*")
                        .exposedHeaders("*");


                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200", "https://portfolio3-2.onrender.com")
                        .allowedMethods("*");
            }

        };
    }
}