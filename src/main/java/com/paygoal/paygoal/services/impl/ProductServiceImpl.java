package com.paygoal.paygoal.services.impl;

import com.paygoal.paygoal.DTO.NewProductDTO;
import com.paygoal.paygoal.DTO.UpdateProductDTO;
import com.paygoal.paygoal.models.Product;
import com.paygoal.paygoal.repositories.ProductRepository;
import com.paygoal.paygoal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void createProduct(NewProductDTO newProductDTO) throws Exception {

        if(newProductDTO.getName().isEmpty()) throw new Exception("missing name");

        if(newProductDTO.getDescription().isEmpty()) throw new Exception("missing description");

        if (newProductDTO.getDescription().length() > 1000) throw new Exception("the maximum of characters is 1000");

        if(newProductDTO.getPrice() == null) throw new Exception("missing price");

        if(newProductDTO.getStock() < 1) throw new Exception("The number entered is wrong");

        Product newProduct =new Product(newProductDTO.getName(),newProductDTO.getDescription(),newProductDTO.getPrice(),newProductDTO.getStock());

        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(UpdateProductDTO updateProductDTO) throws Exception {

        Product selectProduct  ;
        boolean isEmpty = true;
        selectProduct = productRepository.findById(updateProductDTO.getId()).orElse(null);

        if(selectProduct == null){
            throw new Exception("The product Doesn't exist");
        }
        if (!updateProductDTO.getName().isEmpty()){
            selectProduct.setName(updateProductDTO.getName());
            isEmpty = false;
        }
        if (!updateProductDTO.getDescription().isEmpty()){
            selectProduct.setDescription(updateProductDTO.getDescription());
            isEmpty = false;
        }
        if (updateProductDTO.getPrice() != null){
            selectProduct.setPrice(updateProductDTO.getPrice());
            isEmpty = false;
        }

        if (updateProductDTO.getStock() >= 0){
            selectProduct.setStock(updateProductDTO.getStock());
            isEmpty = false;
        }


        if (isEmpty) throw new Exception("You haven't entered any data");
        else productRepository.save(selectProduct);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        Product selectProduct = productRepository.findById(id).get();

        if(selectProduct == null){
            throw new Exception("The product doesn't exist");
        }else {
            selectProduct.setStatus(!selectProduct.getStatus());
        }
        productRepository.save(selectProduct);
    }

    @Override
    public List<Product> orderPrice()  {
       return productRepository.findAll().stream().sorted(Comparator.comparing(p -> p.getPrice())).collect(Collectors.toList());
    }


}
