package com.paygoal.paygoal.repositories;

import com.paygoal.paygoal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Long> {

}
