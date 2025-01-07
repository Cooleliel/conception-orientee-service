package com.myportfolio.users_service.utils.mapper;

import org.springframework.stereotype.Component;

import com.myportfolio.users_service.adapters.dto.UserResponse;
import com.myportfolio.users_service.adapters.jpa.schema.UserSchema;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.usescases.user.command.BaseUserCommand;

@Component // Annotation qui marque cette classe comme un composant Spring.
public class UserMapper {

    // Convertit un UserModel (objet métier) en UserSchema (entité persistante).
    public UserSchema toSchema(UserModel model) {
        if (model == null) {
            return null; // Retourne null si le modèle est null.
        }
        UserSchema schema = new UserSchema();
        schema.setId(model.getId());
        schema.setUsername(model.getUsername());
        schema.setEmail(model.getEmail());
        schema.setPassword(model.getPassword());
        return schema; // Retourne l'entité créée.
    }

    // Convertit un UserSchema (entité persistante) en UserModel (objet métier).
    public UserModel toModel(UserSchema schema) {
        if (schema == null) {
            return null; // Retourne null si l'entité est null.
        }
        UserModel model = new UserModel();
        model.setId(schema.getId());
        model.setUsername(schema.getUsername());
        model.setEmail(schema.getEmail());
        model.setPassword(schema.getPassword());
        return model; // Retourne le modèle créé.
    }
    // Conversion d'une commande en modèle utilisateur
    public UserModel toModel(BaseUserCommand command) {
        if (command == null) {
            return null; // Retourne null si la commande est vide
        }
        UserModel model = new UserModel();
        model.setUsername(command.username()); // Définit le nom d'utilisateur
        model.setEmail(command.email()); // Définit l'email
        model.setPassword(command.password()); // Définit le mot de passe
        return model; // Retourne le modèle utilisateur
    }

    // Conversion d'un modèle utilisateur en réponse publique
    public UserResponse toPublic(UserModel model) {
        if (model == null) {
            return null; // Retourne null si le modèle est vide
        }
        return UserResponse.builder()
            .id(model.getId()) // Définit l'ID de l'utilisateur
            .username(model.getUsername()) // Définit le nom d'utilisateur
            .email(model.getEmail()) // Définit l'email
            .password(model.getPassword()) // Définit le mot de passe
            .build(); // Retourne l'objet réponse
    }
}
