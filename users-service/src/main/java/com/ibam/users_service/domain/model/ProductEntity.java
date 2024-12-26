package com.ibam.users_service.domain.model;

public class ProductEntity {

    //constructor
    public ProductEntity() {};

    public ProductEntity(
        String name,
        String description,
        Double price,
        Integer stock
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    
    
    //variables
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private UserEntity user ;


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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
}
