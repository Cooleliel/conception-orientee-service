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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Service utilisateurs", description = "Endpoints pour la gestion des utilisateurs")
@Transactional
@RestController
@RequestMapping("/api/users") // Chemin de base pour les endpoints utilisateurs
public class RegisterUserController {

    @Autowired
    private RegisterUserUseCase useCase; // Cas d'utilisation pour enregistrer un utilisateur

    private final UserMapper mapper = new UserMapper(); // Mapper pour les conversions

    @Operation(summary = "Enregistrer un nouvel utilisateur")
    @ApiResponse(
        responseCode = "201", 
        description = "Utilisateur enregistre avec succes",
        content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserResponse.class)
            )
        }
    )
    @BadRequestApiResponse
    @UnauthorizedApiResponse
    @ForbiddenApiResponse
    @NotFoundApiResponse
    @DefaultErrorApiResponse
    @PostMapping("/register") // Endpoint pour l'enregistrement
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest request) {
        UserModel model = useCase.execute(request); // Exécute l'enregistrement
        UserResponse requestResponse = mapper.toPublic(model); // Convertit le modèle en réponse publique
        return ResponseEntity.created(URI.create("/users/" + requestResponse.id())).body(requestResponse);

        //return ResponseEntity.status(HttpStatus.CREATED).body(requestResponse); // Retourne la réponse avec un statut HTTP 201
    }
}
