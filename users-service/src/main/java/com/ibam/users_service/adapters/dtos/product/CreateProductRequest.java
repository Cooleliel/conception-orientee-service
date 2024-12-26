package com.ibam.users_service.adapters.dtos.product;

import com.ibam.users_service.usecases.product.command.BaseProductCommand;

import lombok.Builder;

@Builder
public record CreateProductRequest(
    String name,
    String description,
    Double price,
    Integer stock
) implements BaseProductCommand{}
