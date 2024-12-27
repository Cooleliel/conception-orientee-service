package com.ibam.users_service.adapters.dtos.user;

import com.ibam.users_service.adapters.jpa.schema.UserSchema.Role;

import lombok.Builder;

@Builder
public record UserResponse(
    //@Schema(example = "01")
    Long id,

    //@Schema(example="COULIBALY Eliel")
    String username,

    //@Schema(example = "example@gmail.com")
    String email,

    //@Schema(example = "vendeur")
    Role role

    //@Schema(example = ["x","y","a"])
    //Set<ProductEntity> products 
) {
    
}
