package com.myportfolio.users_service.adapters.dto;

import lombok.Builder;

// Objet de réponse publique pour l'utilisateur
@Builder
public record UserResponse(
    Long id, // ID de l'utilisateur
    String username, // Nom d'utilisateur
    String email, // Adresse e-mail
    String password // Mot de passe
) {}
