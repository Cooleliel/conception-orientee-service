package com.ibam.users_service.adapters.controllers.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibam.users_service.adapters.dtos.product.CreateProductRequest;
import com.ibam.users_service.adapters.dtos.product.ProductResponse;
import com.ibam.users_service.domain.model.ProductEntity;
import com.ibam.users_service.usecases.product.CreateProductUseCase;
import com.ibam.users_service.utils.mapper.ProductMapper;

@RestController
@RequestMapping("api/v1")
public class CreateProductController {
    private final CreateProductUseCase createProductUseCase;
    private final ProductMapper productMapper = new ProductMapper();

    public CreateProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest body) {
        ProductEntity productEntity = createProductUseCase.execute(body);
        ProductResponse productResponse = productMapper.toPublic(productEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
