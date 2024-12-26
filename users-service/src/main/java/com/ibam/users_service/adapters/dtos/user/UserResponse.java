package com.ibam.users_service.adapters.dtos.user;

import java.util.Set;

import com.ibam.users_service.domain.model.ProductEntity;

import lombok.Builder;

@Builder
public record UserResponse(
    //@Schema(example = "01")
    Long id,

    //@Schema(example="COULIBALY Eliel")
    String name,

    //@Schema(example = "example@gmail.com")
    String email,

    //@Schema(example = "vendeur")
    String role,

    //@Schema(example = ["x","y","a"])
    Set<ProductEntity> products 
) {
    
}
