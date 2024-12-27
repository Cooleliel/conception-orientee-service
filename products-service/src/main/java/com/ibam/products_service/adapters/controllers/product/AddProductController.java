package com.ibam.products_service.adapters.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibam.products_service.adapters.dtos.product.AddProductRequest;
import com.ibam.products_service.adapters.dtos.product.ProductResponse;
import com.ibam.products_service.domain.model.ProductEntity;
import com.ibam.products_service.usecases.product.AddProductUseCase;
import com.ibam.products_service.utils.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class AddProductController {

    @Autowired
    private AddProductUseCase addProductUseCase;
    private final ProductMapper productMapper = new ProductMapper();


    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody AddProductRequest body, @RequestParam Long vendorId) {
        ProductEntity productEntity = addProductUseCase.execute(body, vendorId);
        ProductResponse productResponse = productMapper.toPublic(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
