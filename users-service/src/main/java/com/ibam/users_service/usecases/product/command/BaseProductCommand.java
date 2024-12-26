package com.ibam.users_service.usecases.product.command;

public interface BaseProductCommand {
    String name();
    String description();
    Double price();
    Integer stock();
}
