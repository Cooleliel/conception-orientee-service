package com.myportfolio.users_service.adapters.dto;

import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;
import com.myportfolio.users_service.utils.enums.RoleType;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Builder;

// Requête d'enregistrement d'un utilisateur
@Builder
public record RegisterUserRequest(
    @Schema(example = "johnman", requiredMode = RequiredMode.REQUIRED) String username,
    @Schema(example = "john@example.com", requiredMode = RequiredMode.NOT_REQUIRED) String email,
    @Schema(example = "motdepasse", requiredMode = RequiredMode.REQUIRED) String password,
    @Schema(example = "SELLER", requiredMode = RequiredMode.REQUIRED) RoleType role
) implements BaseUserCommand {} // Implémente le contrat pour les commandes utilisateur