package com.myportfolio.users_service.ports.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myportfolio.users_service.adapters.jpa.schema.UserSchema;

@Repository // Annotation qui marque cette interface comme un repository Spring.
public interface UserJpaRepository extends JpaRepository<UserSchema, Long> {
    // Méthode pour trouver un utilisateur par son nom d'utilisateur.
    Optional<UserSchema> findByUsername(String username);
}
