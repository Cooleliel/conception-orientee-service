package com.myportfolio.users_service.adapters.dto;

import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;

import lombok.Builder;

// Objet représentant une commande pour enregistrer un utilisateur
@Builder
public record RegisterUserRequest(
    String username,
    String email,
    String password
) implements BaseUserCommand {} // Implémente le contrat pour les commandes utilisateur
