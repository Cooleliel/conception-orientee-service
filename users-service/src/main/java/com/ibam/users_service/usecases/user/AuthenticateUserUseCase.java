package com.ibam.users_service.usecases.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibam.users_service.domain.gateway.UserGateway;
import com.ibam.users_service.domain.model.UserEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticateUserUseCase {

    @Autowired
    private UserGateway userGateway;

    public Optional<UserEntity> execute(String email, String password) {

        Optional<UserEntity> userEntity = userGateway.findByEmail(email)
            .filter(user -> user.getPassword().equals(password));

        return userEntity;
    }

}
