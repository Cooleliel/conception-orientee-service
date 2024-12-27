package com.ibam.products_service.adapters.dtos.product;

import com.ibam.products_service.usecases.product.command.BaseProductCommand;

import lombok.Builder;

@Builder
public record AddProductRequest(
    String name,
    String description,
    double price,
    int stock
) implements BaseProductCommand{}
