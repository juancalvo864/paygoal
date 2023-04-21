package com.paygoal.paygoal.repositories;

import com.paygoal.paygoal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository <Product,Long> {


}
