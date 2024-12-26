package com.ibam.users_service.ports.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibam.users_service.adapters.jpa.schema.ProductSchema;

@Repository
public interface ProductRepository extends JpaRepository<ProductSchema, Long>{
    Set<ProductSchema> findByUserId(Long id);
}
