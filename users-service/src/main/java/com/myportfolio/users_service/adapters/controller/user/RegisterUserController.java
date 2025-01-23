package com.myportfolio.users_service.adapters.controller.user;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myportfolio.users_service.adapters.config.swagger.api_response.BadRequestApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.CreatedRequestApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.DefaultErrorApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.ForbiddenApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.NotFoundApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.UnauthorizedApiResponse;
import com.myportfolio.users_service.adapters.dto.RegisterUserRequest;
import com.myportfolio.users_service.adapters.dto.UserResponse;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.RegisterUserUseCase;
import com.myportfolio.users_service.utils.mapper.UserMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

// Contrôleur principal pour gérer les utilisateurs
@Tag(name = "Service utilisateurs", description = "Endpoints pour la gestion des utilisateurs")
@Transactional // Indique que les méthodes de ce contrôleur nécessitent une gestion des transactions
@RestController // Déclare cette classe comme un contrôleur REST
@RequestMapping("/api/users") // Définit le chemin de base pour les endpoints de l'utilisateur
public class RegisterUserController {

    @Autowired
    private RegisterUserUseCase useCase; // Injecte la logique métier pour l'enregistrement des utilisateurs

    private final UserMapper mapper = new UserMapper(); // Mapper pour convertir entre modèles et DTOs

    // Endpoint pour enregistrer un nouvel utilisateur
    @Operation(summary = "Enregistrer un nouvel utilisateur") // Documentation Swagger pour ce point d'entrée
    @CreatedRequestApiResponse
    @BadRequestApiResponse
    @UnauthorizedApiResponse
    @ForbiddenApiResponse
    @NotFoundApiResponse
    @DefaultErrorApiResponse
    @PostMapping(name = "POST") // Déclare un endpoint POST à "/api/users/register"
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        // 1. Exécute la logique métier pour enregistrer un utilisateur
        UserModel model = useCase.execute(request);
        // 2. Convertit le modèle interne en une réponse utilisateur publique
        UserResponse requestResponse = mapper.toPublic(model);
        // 3. Retourne une réponse HTTP avec l'URL de la ressource créée
        return ResponseEntity.created(URI.create("/users/" + requestResponse.id())).body(requestResponse);
    }
}