package com.paygoal.paygoal.DTO;

import com.paygoal.paygoal.models.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int stock;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
