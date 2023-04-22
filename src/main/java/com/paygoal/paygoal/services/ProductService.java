package com.paygoal.paygoal.services;

import com.paygoal.paygoal.DTO.NewProductDTO;
import com.paygoal.paygoal.DTO.UpdateProductDTO;
import com.paygoal.paygoal.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void save(Product product);

    public List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);
    public void createProduct(NewProductDTO newProductDTO) throws Exception;

    public void updateProduct(UpdateProductDTO updateProductDTO) throws Exception;

    public void deleteProduct(Long id) throws Exception;

}
