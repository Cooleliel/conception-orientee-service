package com.myportfolio.users_service.usescases.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myportfolio.users_service.domain.gateway.UserGateway;
import com.myportfolio.users_service.domain.model.UserModel;
import com.myportfolio.users_service.utils.exception.ResourceNotFoundException;

@Service
@Transactional
public class GetUserProfileByIdUseCase {
    
    @Autowired
    private UserGateway userGateway;

    public UserModel execute(Long id) throws ResourceNotFoundException{
        UserModel retrievedUser = userGateway.findByUserId(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Utilisateur", "id", id)
            );
        return retrievedUser;
    }
}
