package com.ibam.users_service.domain.gateway;

import java.util.Optional;

import com.ibam.users_service.domain.model.UserEntity;

public interface UserGateway {

    boolean existingEmail(String email);
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    
    UserEntity create(UserEntity userEntity);
    Optional<UserEntity> findById(Long id);
    UserEntity update(UserEntity userEntity);
    void deletedById(Long id);
}