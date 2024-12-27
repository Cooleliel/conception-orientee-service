package com.ibam.users_service.adapters.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibam.users_service.adapters.dtos.user.CreateUserRequest;
import com.ibam.users_service.adapters.dtos.user.UserResponse;
import com.ibam.users_service.domain.model.UserEntity;
import com.ibam.users_service.usecases.user.CreateUserUseCase;
import com.ibam.users_service.utils.mapper.UserMapper;

@RestController
@RequestMapping("/users")
public class CreateUserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper = new UserMapper();


    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser( @RequestBody CreateUserRequest body) {
        UserEntity entity = createUserUseCase.execute(body);
        UserResponse response = userMapper.toPublic(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
