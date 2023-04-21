package com.paygoal.paygoal.services.impl;

import com.paygoal.paygoal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {

    @Autowired
    ProductRepository productRepository;


}
