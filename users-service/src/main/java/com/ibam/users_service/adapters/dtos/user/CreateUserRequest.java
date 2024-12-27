package com.ibam.users_service.adapters.dtos.user;

import com.ibam.users_service.adapters.jpa.schema.UserSchema.Role;
import com.ibam.users_service.usecases.user.command.BaseUserCommand;

import lombok.Builder;

@Builder
public record CreateUserRequest(
    //@Schema(example = 'COULIBALY Eliel', requiredMode = Schema.RequireMode.REQUIRED)
    String username, 
    String email, 
    String password, 
    Role role) implements BaseUserCommand{}
