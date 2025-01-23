package com.myportfolio.users_service.adapters.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myportfolio.users_service.adapters.config.swagger.api_response.BadRequestApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.DefaultErrorApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.NotFoundApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.SuccessRequestApiResponse;
import com.myportfolio.users_service.adapters.config.swagger.api_response.UnauthorizedApiResponse;
import com.myportfolio.users_service.adapters.dto.UserResponse;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.GetUserProfileByIdUseCase;
import com.myportfolio.users_service.utils.mapper.UserMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Service utilisateurs", description = "Endpoints pour la gestion des utilisateurs")
@Transactional
@RestController
@RequestMapping("/api/users")
public class GetUserProfileByIdController {
    @Autowired
    private GetUserProfileByIdUseCase getUserProfileByIdUseCase;
    private final UserMapper mapper = new UserMapper(); // Mapper pour convertir entre modèles et DTOs

    @Operation(summary = "Recuperer les informations d'un utilisateur enregistre")
    @SuccessRequestApiResponse
    @BadRequestApiResponse
    @UnauthorizedApiResponse
    @NotFoundApiResponse
    @DefaultErrorApiResponse
    @GetMapping(name = "GET", path = "/{id}/profile")
    public ResponseEntity<UserResponse> getUserProfileById(
        @PathVariable
        @Parameter(name = "id", description = "Id de l'utilisateur", example = "1", required = true)
        Long id
    ) {
        UserModel userModel = getUserProfileByIdUseCase.execute(id);
        UserResponse requestResponse = mapper.toPublic(userModel);
        return ResponseEntity.ok(requestResponse);
    }
}
