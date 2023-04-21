package com.paygoal.paygoal.services;

import com.paygoal.paygoal.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void save(Product product);

    public List<Product> findAll();

    Optional<Product> findById(Long id);


}
