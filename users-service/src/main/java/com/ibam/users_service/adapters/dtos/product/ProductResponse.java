package com.ibam.users_service.adapters.dtos.product;

import lombok.Builder;

@Builder
public record ProductResponse(
    Long id,
    String name,
    String description,
    Double price,
    Integer stock
) {}
