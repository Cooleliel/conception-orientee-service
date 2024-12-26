package com.ibam.users_service.adapters.dtos.product;

import java.util.List;
import java.util.Set;

import lombok.Builder;

@Builder
public record ProductsListResponse(
    List<ProductResponse> items
) {
    
}
