package com.ibam.products_service.usecases.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibam.products_service.domain.gateway.ProductGateway;
import com.ibam.products_service.domain.model.ProductEntity;
import com.ibam.products_service.usecases.product.command.BaseProductCommand;
import com.ibam.products_service.utils.mapper.ProductMapper;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class AddProductUseCase {

    @Autowired
    private ProductGateway productGateway;
    private final ProductMapper productMapper = new ProductMapper();


    public ProductEntity execute(BaseProductCommand command, Long vendorId) {

        ProductEntity productEntity = productMapper.toModel(command);
        productEntity.setVendorId(vendorId);
        return productGateway.create(productEntity);
    }
    
}
