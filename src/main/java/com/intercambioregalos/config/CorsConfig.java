package com.intercambioregalos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todas las rutas
                .allowedOrigins("http://localhost:8080", "http://localhost:3000") // Agrega los orígenes permitidos
                .allowedMethods("*") // Permite todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite el envío de cookies o credenciales
    }
}