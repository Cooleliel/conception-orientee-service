package com.ibam.products_service.domain.model;


public class ProductEntity {

    //variables

    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Long vendorId ; //reference a l'utilisateur

    //constructor
    public ProductEntity() {};

    public ProductEntity(
        String name,
        String description,
        double price,
        int stock,
        Long vendorId
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.vendorId = vendorId;
    }


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

    public Long getVendorId() {
        return vendorId;
    }
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
