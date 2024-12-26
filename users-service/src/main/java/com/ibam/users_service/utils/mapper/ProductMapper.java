package com.ibam.users_service.utils.mapper;

import java.util.Set;

import com.ibam.users_service.adapters.dtos.product.ProductResponse;
import com.ibam.users_service.adapters.dtos.product.ProductsListResponse;
import com.ibam.users_service.adapters.jpa.schema.ProductSchema;
import com.ibam.users_service.domain.model.ProductEntity;
import com.ibam.users_service.usecases.product.command.BaseProductCommand;

public class ProductMapper {
    private final UserMapper userMapper = new UserMapper();
    public ProductEntity toModel(ProductSchema productSchema) {
        if (productSchema == null) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productSchema.getId());
        productEntity.setName(productSchema.getName());
        productEntity.setDescription(productSchema.getDescription());
        productEntity.setPrice(productSchema.getPrice());
        productEntity.setStock(productSchema.getStock());
        productEntity.setUser(userMapper.toModel(productSchema.getUser()));
        return productEntity;
    }

    public ProductEntity toModel(BaseProductCommand command) {
        if (command == null) {
            return null;
        }
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(command.name());
        productEntity.setDescription(command.description());
        productEntity.setPrice(command.price());
        productEntity.setStock(command.stock());
        return productEntity;
    }

    public ProductSchema toSchema(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        ProductSchema productSchema = new ProductSchema();
        productSchema.setId(productEntity.getId());
        productSchema.setName(productEntity.getName());
        productSchema.setDescription(productEntity.getDescription());
        productSchema.setPrice(productEntity.getPrice());
        productSchema.setStock(productEntity.getStock());
        productSchema.setUser(userMapper.toSchema(productEntity.getUser()));
        return productSchema;
    }

    public ProductResponse toPublic(ProductEntity productEntity) {
        if (productEntity == null) {
            return null;
        }
        return ProductResponse
        .builder()
        .name(productEntity.getName())
        .description(productEntity.getDescription())
        .price(productEntity.getPrice())
        .stock(productEntity.getStock())
        .build();
    }

    public ProductsListResponse toPublic(Set<ProductEntity> productsEntity) {
        if (productsEntity == null || productsEntity.isEmpty()) {
            return null;
        }
        return ProductsListResponse
        .builder()
        .items(productsEntity.stream().map(this::toPublic).toList())
        .build();
    }
}
