package com.myportfolio.users_service.adapters.dto;

import com.myportfolio.users_service.utils.enums.RoleType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

// Objet de réponse publique pour l'utilisateur
@Builder
public record UserResponse(
    @Schema(example = "1") Long id, // ID de l'utilisateur
    @Schema(example = "entrepreneur") String username, // Nom d'utilisateur
    @Schema(example = "johndoe@example.com") String email, // Adresse e-mail
    @Schema(example = "motdepasse") String password, // Mot de passe
    @Schema(example = "ADMIN") RoleType role
) {}
