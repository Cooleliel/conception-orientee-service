package com.ibam.users_service.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserEntity {

    //constructor
    public UserEntity(){};

    public UserEntity(
        String name,
        String email,
        String password,
        String role
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    
    //variables
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Set<ProductEntity> products = new HashSet<>();


    //Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Le mot de passe doit contenir au moins 6 caracteres");
        }
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }
    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }
    public void addProduct(ProductEntity product) {
        products.add(product);
        product.setUser(this);
    }
    public void removeProduct(ProductEntity product) {
        products.remove(product);
        product.setUser(null);
    }
    

    // Equals and hashCode based on email (unique)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity user = (UserEntity) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
