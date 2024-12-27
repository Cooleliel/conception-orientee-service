package com.ibam.products_service.adapters.dtos.product;

import lombok.Builder;

@Builder
public record ProductResponse(
    Long id,
    String name,
    String description,
    double price,
    int stock
) {}
