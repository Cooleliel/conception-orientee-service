package com.ibam.users_service.usecases.product;

import org.springframework.stereotype.Service;

import com.ibam.users_service.domain.gateway.ProductGateway;
import com.ibam.users_service.domain.model.ProductEntity;
import com.ibam.users_service.usecases.product.command.BaseProductCommand;
import com.ibam.users_service.utils.mapper.ProductMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CreateProductUseCase {
    private final ProductGateway productGateway;
    private final ProductMapper productMapper = new ProductMapper();


    public CreateProductUseCase(ProductGateway productGateway){
        this.productGateway = productGateway;
    }


    public ProductEntity execute(BaseProductCommand command) {
        ProductEntity productEntity = productMapper.toModel(command);
        return productGateway.create(productEntity);
    }
    
}
