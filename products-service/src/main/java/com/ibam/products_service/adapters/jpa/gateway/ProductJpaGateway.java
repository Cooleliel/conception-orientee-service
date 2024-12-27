package com.ibam.products_service.adapters.jpa.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibam.products_service.adapters.jpa.schema.ProductSchema;
import com.ibam.products_service.domain.gateway.ProductGateway;
import com.ibam.products_service.domain.model.ProductEntity;
import com.ibam.products_service.ports.repositories.ProductJpaRepository;
import com.ibam.products_service.utils.mapper.ProductMapper;

@Service
public class ProductJpaGateway implements ProductGateway{

    @Autowired
    private ProductJpaRepository productJpaRepository;

    private final ProductMapper productMapper = new ProductMapper();

    @Override
    public List<ProductEntity> findByVendor(Long id) {
        List<ProductSchema> productSchemas = productJpaRepository.findByVendorId(id);
        return productSchemas.stream().map(productMapper::toModel).toList();
    }

    @Override
    public ProductEntity create(ProductEntity productEntity) {
        ProductSchema productSchema = productMapper.toSchema(productEntity);
        ProductSchema addedProduct = productJpaRepository.save(productSchema);
        return productMapper.toModel(addedProduct);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
    return productJpaRepository.findById(id).map(productMapper::toModel);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        ProductSchema productSchema = productMapper.toSchema(productEntity);
        ProductSchema updatedProduct = productJpaRepository.save(productSchema);
        return productMapper.toModel(updatedProduct);
    }

    @Override
    public void deletedById(Long id) {
        productJpaRepository.deleteById(id);
    }
    
}
