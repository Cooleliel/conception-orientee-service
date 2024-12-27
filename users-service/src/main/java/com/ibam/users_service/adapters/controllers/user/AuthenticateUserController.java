package com.ibam.users_service.adapters.controllers.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibam.users_service.domain.model.UserEntity;
import com.ibam.users_service.usecases.user.AuthenticateUserUseCase;

@RestController
@RequestMapping("/users")
public class AuthenticateUserController {

    @Autowired
    private AuthenticateUserUseCase authenticateUserUseCase;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(
        @RequestParam String email, 
        @RequestParam String password) {
        Optional<UserEntity> userEntity = authenticateUserUseCase.execute(email, password);
        return userEntity.map(user -> ResponseEntity.ok("Connexion reussie"))
            .orElse(ResponseEntity.status(401).body("Identifiants invalides"));
    }
}
