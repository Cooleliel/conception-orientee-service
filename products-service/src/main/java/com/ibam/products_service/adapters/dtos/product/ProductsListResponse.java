package com.ibam.products_service.adapters.dtos.product;

import java.util.List;

import lombok.Builder;

@Builder
public record ProductsListResponse(
    List<ProductResponse> items
) {
    
}
