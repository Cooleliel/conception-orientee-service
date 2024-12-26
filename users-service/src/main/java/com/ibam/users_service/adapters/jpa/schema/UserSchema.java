package com.ibam.users_service.adapters.jpa.schema;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserSchema {
    //constructor
    public UserSchema(){};

    public UserSchema(
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductSchema> products = new HashSet<ProductSchema>();


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

    public Set<ProductSchema> getProducts() {
        return products;
    }
    public void setProducts(Set<ProductSchema> products) {
        this.products = products;
    }
    public void addProduct(ProductSchema product) {
        products.add(product);
        product.setUser(this);
    }
    public void removeProduct(ProductSchema product) {
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
        UserSchema user = (UserSchema) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
