package com.ibam.users_service.adapters.dtos.user;

import lombok.Builder;

@Builder
public record ProductResponse(
    Long id,
    String name,
    String description,
    double price,
    int stock
) {}
