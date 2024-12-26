package com.ibam.users_service.adapters.controllers.user;

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

//@Tag(name = "Gestion des utilisateurs")
@RestController
@RequestMapping("api/v1")
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper = new UserMapper();

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    //@Operation(summary = "Creer un nouvel utilisateur")
/**     @ApiResponse(
        responseCode = "201",
        description = "Utilisateur cree",
        content = {
            @Content(
                mediaType =  "application/json"
                schema = @Schema(implementation = UserResponse.class)
            )
        }
    )
    //@BadRequestApiResponse
    //@UnauthorizedApiResponse
    //@ForbiddenApiResponse
    //@NotFoundApiResponse
    .@DefaultErrorApiResponse
**/
    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser( @RequestBody CreateUserRequest body) {
        UserEntity entity = createUserUseCase.execute(body);
        UserResponse response = userMapper.toPublic(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
