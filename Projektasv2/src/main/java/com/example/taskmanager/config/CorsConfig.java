package com.example.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig klasė atsakinga už CORS (Cross-Origin Resource Sharing) konfigūraciją.
 * Ši klasė leidžia nustatyti, kurie domenai gali pasiekti serverio API.
 */
@Configuration
public class CorsConfig {

    /**
     * Sukuria ir grąžina `WebMvcConfigurer` objektą, kuris nustato CORS taisykles.
     *
     * @return `WebMvcConfigurer` objektas, turintis CORS konfigūraciją.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            /**
             * Prideda CORS taisykles, leidžiančias sąveiką tarp domenų.
             *
             * @param registry CORS registras, kuriame apibrėžiamos taisyklės.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Leidžia visus URL adresus.
                        .allowedOrigins("http://localhost:3000") // Leidžia užklausas tik iš "http://localhost:3000".
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Leidžia šiuos HTTP metodus.
            }
        };
    }
}
