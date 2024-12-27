package com.ibam.products_service.adapters.controllers.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibam.products_service.domain.model.ProductEntity;
import com.ibam.products_service.usecases.product.GetProductsByVendorIdUseCase;

@RestController
@RequestMapping("/products")
public class GetProductsByVendorIdController {

    @Autowired
    private GetProductsByVendorIdUseCase getProductsByVendorIdUseCase;


    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<ProductEntity>> createProduct(@PathVariable Long vendorId) {
        List<ProductEntity> productResponse = getProductsByVendorIdUseCase.execute(vendorId);
        return ResponseEntity.ok(productResponse);
    }
}
