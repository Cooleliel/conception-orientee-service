package com.myportfolio.users_service.adapters.dto;

import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

// Requête d'enregistrement d'un utilisateur
@Builder
public record RegisterUserRequest(
    @Schema(example = "johnman") String username,
    @Schema(example = "john@example.com") String email,
    @Schema(example = "motdepasse") String password
) implements BaseUserCommand {} // Implémente le contrat pour les commandes utilisateur