package com.myportfolio.users_service.domain.gateway;

import java.util.Optional;

import com.myportfolio.users_service.domain.model.UserModel;

public interface UserGateway {
    // Déclare les méthodes d'accès aux données pour les utilisateurs.

    UserModel Register(UserModel model); // Enregistre un utilisateur.
    Optional<UserModel> findByUserId(Long id); // Recherche un utilisateur par ID.
    Optional<UserModel> findByUsername(String username); // Recherche un utilisateur par son nom.
    Optional<UserModel> findByEmail(String email); // Recherche un utilisateur par son email.
    UserModel update(UserModel model); // Met à jour un utilisateur.
    void deleteByUserId(Long id); // Supprime un utilisateur par ID.
}