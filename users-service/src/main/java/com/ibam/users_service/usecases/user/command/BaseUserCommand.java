package com.ibam.users_service.usecases.user.command;

import com.ibam.users_service.adapters.jpa.schema.UserSchema.Role;

public interface BaseUserCommand {
    String username();
    String email();
    String password();
    Role role();
}
