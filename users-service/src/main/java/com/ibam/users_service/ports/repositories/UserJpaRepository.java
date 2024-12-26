package com.ibam.users_service.ports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibam.users_service.adapters.jpa.schema.UserSchema;

@Repository
public interface UserJpaRepository extends JpaRepository<UserSchema, Long>{
    boolean existsByEmail(String email);
}