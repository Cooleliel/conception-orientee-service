package com.ibam.users_service.usecases.user;

import org.springframework.stereotype.Service;

import com.ibam.users_service.domain.gateway.UserGateway;
import com.ibam.users_service.domain.model.UserEntity;
import com.ibam.users_service.usecases.user.command.BaseUserCommand;
import com.ibam.users_service.utils.mapper.UserMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CreateUserUseCase {
    private final UserGateway userGateway;
    private final UserMapper userMapper = new UserMapper();

    public CreateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public UserEntity execute(BaseUserCommand command) {
        if(userGateway.existingEmail(command.email())){
            throw new IllegalArgumentException("Cette adresse mail existe deja!");
        }
        UserEntity entity = userMapper.toModel(command);
        return userGateway.create(entity);
    }
}
