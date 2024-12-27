package com.ibam.products_service.usecases.product.command;

public interface BaseProductCommand {
    String name();
    String description();
    double price();
    int stock();
}
