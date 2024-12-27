package com.ibam.users_service.utils.mapper;

import org.springframework.stereotype.Component;

import com.ibam.users_service.adapters.dtos.user.UserResponse;
import com.ibam.users_service.adapters.jpa.schema.UserSchema;
import com.ibam.users_service.domain.model.UserEntity;
import com.ibam.users_service.usecases.user.command.BaseUserCommand;

@Component
public class UserMapper {

    public UserEntity toModel(UserSchema schema) {
        if (schema == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setId(schema.getId());
        entity.setEmail(schema.getEmail());
        entity.setUserName(schema.getUserName());
        entity.setPassword(schema.getPassword());
        entity.setRole(schema.getRole());
        return entity;
    }

    public UserEntity toModel(BaseUserCommand command) {
        if (command == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setEmail(command.email());
        entity.setUserName(command.username());
        entity.setPassword(command.password());
        entity.setRole(command.role());
        return entity;
    }

    public UserSchema toSchema(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserSchema schema = new UserSchema();
        schema.setId(entity.getId());
        schema.setEmail(entity.getEmail());
        schema.setUserName(entity.getUserName());
        schema.setPassword(entity.getPassword());
        schema.setRole(entity.getRole());
        return schema;
    }

    public UserResponse toPublic(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return UserResponse
        .builder()
        .id(entity.getId())
        .username(entity.getUserName())
        .email(entity.getEmail())
        .role(entity.getRole())
        .build();
    }
}
