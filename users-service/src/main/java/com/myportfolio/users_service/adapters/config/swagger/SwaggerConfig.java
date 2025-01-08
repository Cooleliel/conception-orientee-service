package com.myportfolio.users_service.adapters.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

// Configuration Swagger pour documenter les API
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Users Service API") // Titre pour la documentation
                .version("1.0.0") // Version de l'API
                .description("Documentation des endpoints pour la gestion des utilisateurs"));
    }
}