package com.myportfolio.users_service.usescases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myportfolio.users_service.domain.gateway.UserGateway;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;
import com.myportfolio.users_service.utils.exception.ConflictingOperationException;
import com.myportfolio.users_service.utils.exception.MissingAttributeException;
import com.myportfolio.users_service.utils.mapper.UserMapper;

@Service
@Transactional // Gère automatiquement les transactions
public class RegisterUserUseCase {

    @Autowired
    private UserGateway gateway; // Interface pour les opérations liées à l'utilisateur

    private final UserMapper mapper = new UserMapper(); // Mapper pour convertir les objets

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Méthode principale pour enregistrer un utilisateur
    public UserModel execute(BaseUserCommand command) {

        // Vérification des attributs manquants
        if (command.username() == null || command.username().isEmpty() || command.username().isBlank()) {
            throw new MissingAttributeException("Username est requis");
        }

        // Vérification des conflits
        if (gateway.findByUsername(command.username()).isPresent()) {
            throw new ConflictingOperationException("Un utilisateur avec cet username existe déjà");
        }

        if (command.email() != null && gateway.findByEmail(command.email()).isPresent()) {
            throw new ConflictingOperationException("Un utilisateur avec cet email existe déjà");
        }

        /**  Vérification des autorisations (exemple simplifié)
        if (!hasPermission(command.getUserId())) {
            throw new ForbiddenOperationException("Vous n'avez pas les droits nécessaires pour cette opération");
        }*/

        UserModel unregistredModel = mapper.toModel(command); // Conversion de la commande en modèle utilisateur
        
        // Encodage du mot de passe
        if (unregistredModel.getPassword() != null && !unregistredModel.getPassword().isBlank()) {
            String encodedPassword = passwordEncoder.encode(unregistredModel.getPassword());
            unregistredModel.setPassword(encodedPassword);
        } else {
            throw new MissingAttributeException("Le mot de passe est requis");
        }
        UserModel registredModel = gateway.Register(unregistredModel); // Enregistrement via la passerelle
        return registredModel; // Retourne l'utilisateur enregistré
    }
}
