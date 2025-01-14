package com.ibam.users_service.adapters.jpa.gateway;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibam.users_service.adapters.jpa.schema.UserSchema;
import com.ibam.users_service.domain.gateway.UserGateway;
import com.ibam.users_service.domain.model.UserEntity;
import com.ibam.users_service.ports.repositories.UserJpaRepository;
import com.ibam.users_service.utils.mapper.UserMapper;

@Service
public class UserJpaGateway implements UserGateway{

    @Autowired
    private UserJpaRepository userJpaRepository;
    private final UserMapper userMapper = new UserMapper();


    @Override
    public boolean existingEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public UserEntity create(UserEntity entity) {
        UserSchema schema = userMapper.toSchema(entity);
        UserSchema createdSchema =  userJpaRepository.save(schema);
        return userMapper.toModel(createdSchema);
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userJpaRepository.findById(id).map(userMapper::toModel);
    }

    @Override
    public UserEntity update(UserEntity entity) {
        UserSchema schema = userMapper.toSchema(entity);
        UserSchema updatedSchema =  userJpaRepository.save(schema);
        return userMapper.toModel(updatedSchema);
    }

    @Override
    public void deletedById(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userJpaRepository.findByUsername(username).map(userMapper::toModel);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userJpaRepository.findByEmail(email).map(userMapper::toModel);
    }
    
}
