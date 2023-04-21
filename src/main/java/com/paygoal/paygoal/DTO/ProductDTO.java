package com.paygoal.paygoal.DTO;

public class ProductDTO {
    Long id;
    private String name;
    private String description;
    private int price;
    private int stock;

    public ProductDTO(Long id, String name, String description, int price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
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
