package com.myportfolio.users_service.adapters.jpa.gateway;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myportfolio.users_service.adapters.jpa.schema.UserSchema;
import com.myportfolio.users_service.domain.gateway.UserGateway;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.ports.repositories.UserJpaRepository;
import com.myportfolio.users_service.utils.mapper.UserMapper;

@Service // Annotation qui marque cette classe comme un service Spring pour la logique métier.
public class UserJpaGateway implements UserGateway {

    // Instance du mapper utilisée pour convertir entre UserModel et UserSchema.
    private final UserMapper mapper = new UserMapper();

    @Autowired // Injection automatique du repository pour accéder aux données persistantes.
    private UserJpaRepository jpaRepository;

    @Override
    public UserModel Register(UserModel model) {
        // Conversion du modèle (UserModel) en entité de base de données (UserSchema).
        UserSchema schema = mapper.toSchema(model);
        // Enregistrement de l'entité dans la base de données et conversion du résultat en UserModel.
        UserModel registredModel = mapper.toModel(jpaRepository.save(schema));
        return registredModel; // Retourne le modèle enregistré.
    }

    @Override
    public Optional<UserModel> findByUserId(Long id) {
        // Utilisation de findById pour récupérer un Optional<UserSchema> depuis le JpaRepository.
        Optional<UserSchema> retrievedUserById = jpaRepository.findById(id);

        // Transformation de UserSchema en UserModel en utilisant la méthode map.
        return retrievedUserById.map(mapper::toModel);
    }

    @Override
    public Optional<UserModel> findByUsername(String username) {
        // Utilisation de findByUsername pour récupérer un Optional<UserSchema> depuis le JpaRepository.
        Optional<UserSchema> retrievedUserByUsername = jpaRepository.findByUsername(username);

        // Transformation de UserSchema en UserModel en utilisant map.
        return retrievedUserByUsername.map(mapper::toModel);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        // Utilisation de findByUsername pour récupérer un Optional<UserSchema> depuis le JpaRepository.
        Optional<UserSchema> retrievedUserByUsername = jpaRepository.findByEmail(email);

        // Transformation de UserSchema en UserModel en utilisant map.
        return retrievedUserByUsername.map(mapper::toModel);
    }

    @Override
    public UserModel update(UserModel model) {
        // Conversion du modèle en entité, puis enregistrement en base avec mise à jour.
        UserSchema schema = mapper.toSchema(model);
        UserModel updatedModel = mapper.toModel(jpaRepository.save(schema));
        return updatedModel; // Retourne le modèle mis à jour.
    }

    @Override
    public void deleteByUserId(Long id) {
        // Suppression de l'entité correspondante à l'ID fourni dans la base de données.
        jpaRepository.deleteById(id);
    }
}
