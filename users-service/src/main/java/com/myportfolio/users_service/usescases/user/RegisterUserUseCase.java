package com.myportfolio.users_service.usescases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myportfolio.users_service.domain.gateway.UserGateway;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;
import com.myportfolio.users_service.utils.mapper.UserMapper;

@Service
@Transactional // Gère automatiquement les transactions
public class RegisterUserUseCase {

    @Autowired
    private UserGateway gateway; // Interface pour les opérations liées à l'utilisateur

    private final UserMapper mapper = new UserMapper(); // Mapper pour convertir les objets

    // Méthode principale pour enregistrer un utilisateur
    public UserModel execute(BaseUserCommand command) {
        UserModel unregistredModel = mapper.toModel(command); // Conversion de la commande en modèle utilisateur
        UserModel registredModel = gateway.Register(unregistredModel); // Enregistrement via la passerelle
        return registredModel; // Retourne l'utilisateur enregistré
    }
}
