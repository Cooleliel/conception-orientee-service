package com.ibam.products_service.ports.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibam.products_service.adapters.jpa.schema.ProductSchema;


@Repository
public interface ProductJpaRepository extends JpaRepository<ProductSchema, Long>{
    List<ProductSchema> findByVendorId(Long id);
}
