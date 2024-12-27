package com.ibam.products_service.usecases.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibam.products_service.domain.gateway.ProductGateway;
import com.ibam.products_service.domain.model.ProductEntity;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class GetProductsByVendorIdUseCase {

    @Autowired
    private ProductGateway productGateway;


    public List<ProductEntity> execute(Long vendorId) {
        return productGateway.findByVendor(vendorId);
    }
    
}
