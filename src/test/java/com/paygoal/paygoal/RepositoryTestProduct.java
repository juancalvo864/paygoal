package com.paygoal.paygoal;

import com.paygoal.paygoal.models.Product;
import com.paygoal.paygoal.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.IsNot.not;


@SpringBootTest
public class RepositoryTestProduct {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void existAccount(){
       List<Product> products= productRepository.findAll();
        assertThat(products,is(not(empty())));
    }
}
