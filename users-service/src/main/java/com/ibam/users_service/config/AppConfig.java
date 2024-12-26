package com.ibam.users_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibam.users_service.domain.gateway.ProductGateway;
import com.ibam.users_service.domain.gateway.UserGateway;
import com.ibam.users_service.usecases.product.CreateProductUseCase;
import com.ibam.users_service.usecases.user.CreateUserUseCase;

@Configuration
public class AppConfig {
    
    @Bean
    public CreateUserUseCase createUserUseCase(UserGateway UserGateway) {
        return new CreateUserUseCase(UserGateway);
    }

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCase(productGateway);
    }
}

