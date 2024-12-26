package com.ibam.users_service.adapters.dtos.user;

import com.ibam.users_service.usecases.user.command.BaseUserCommand;

import lombok.Builder;

@Builder
public record CreateUserRequest(
    //@Schema(example = 'COULIBALY Eliel', requiredMode = Schema.RequireMode.REQUIRED)
    String name, 
    String email, 
    String password, 
    String role) implements BaseUserCommand{}
