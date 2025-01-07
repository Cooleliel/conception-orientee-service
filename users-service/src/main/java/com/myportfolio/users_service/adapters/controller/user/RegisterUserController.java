package com.myportfolio.users_service.adapters.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myportfolio.users_service.adapters.dto.RegisterUserRequest;
import com.myportfolio.users_service.adapters.dto.UserResponse;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.RegisterUserUseCase;
import com.myportfolio.users_service.utils.mapper.UserMapper;

@RestController
@RequestMapping("/api/users") // Chemin de base pour les endpoints utilisateurs
public class RegisterUserController {

    @Autowired
    private RegisterUserUseCase useCase; // Cas d'utilisation pour enregistrer un utilisateur

    private final UserMapper mapper = new UserMapper(); // Mapper pour les conversions

    @PostMapping("/register") // Endpoint pour l'enregistrement
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request) {
        UserModel model = useCase.execute(request); // Exécute l'enregistrement
        UserResponse requestResponse = mapper.toPublic(model); // Convertit le modèle en réponse publique
        return ResponseEntity.status(HttpStatus.CREATED).body(requestResponse); // Retourne la réponse avec un statut HTTP 201
    }
}
