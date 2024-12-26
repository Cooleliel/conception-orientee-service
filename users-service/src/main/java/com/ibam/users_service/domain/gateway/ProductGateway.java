package com.ibam.users_service.domain.gateway;

import java.util.Optional;
import java.util.Set;

import com.ibam.users_service.domain.model.ProductEntity;

public interface ProductGateway {
    
    ProductEntity create(ProductEntity productEntity);
    Optional<ProductEntity> findById(Long id);
    Set<ProductEntity> findAllByUser(Long id);
    ProductEntity update(ProductEntity productEntity);
    void deletedById(Long id);
    void deletedAllByUser(Long id);
}
