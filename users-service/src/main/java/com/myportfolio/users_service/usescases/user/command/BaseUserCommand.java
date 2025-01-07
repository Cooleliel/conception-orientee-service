package com.myportfolio.users_service.usescases.user.command;

// Interface définissant un contrat pour les commandes utilisateur
public interface BaseUserCommand {
    String username(); // Nom d'utilisateur
    String email(); // Adresse e-mail
    String password(); // Mot de passe
}
