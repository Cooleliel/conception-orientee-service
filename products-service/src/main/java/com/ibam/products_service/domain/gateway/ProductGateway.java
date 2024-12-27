package com.ibam.products_service.domain.gateway;

import java.util.List;
import java.util.Optional;

import com.ibam.products_service.domain.model.ProductEntity;


public interface ProductGateway {

    List<ProductEntity> findByVendor(Long id);
    
    ProductEntity create(ProductEntity productEntity);
    Optional<ProductEntity> findById(Long id);
    ProductEntity update(ProductEntity productEntity);
    void deletedById(Long id);
}
