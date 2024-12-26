package com.ibam.users_service.usecases.user.command;

public interface BaseUserCommand {
    String name();
    String email();
    String password();
    String role();
}
