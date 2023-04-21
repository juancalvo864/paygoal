package com.paygoal.paygoal.controllers;

import com.paygoal.paygoal.DTO.ProductDTO;
import com.paygoal.paygoal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getAll() {

        return productService.findAll().stream().map(prod -> new ProductDTO(prod)).collect(Collectors.toList());

    }


}
