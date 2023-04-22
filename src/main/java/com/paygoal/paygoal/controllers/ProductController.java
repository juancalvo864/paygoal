package com.paygoal.paygoal.controllers;

import com.paygoal.paygoal.DTO.NewProductDTO;
import com.paygoal.paygoal.DTO.ProductDTO;
import com.paygoal.paygoal.DTO.UpdateProductDTO;
import com.paygoal.paygoal.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
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

    @GetMapping("/product")
    public ProductDTO getByName (String name){
        return new ProductDTO( productService.findByName(name).get());
    }

    @GetMapping("/product/{id}")
    public ProductDTO getById (@PathVariable Long id){
        return new ProductDTO( productService.findById(id).get());
    }


    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody NewProductDTO newProductDTO){
        try{
            productService.createProduct(newProductDTO);
            return new ResponseEntity<>("Product created succesfully", HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PatchMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody UpdateProductDTO updateProductDTO) throws Exception{
        try{
            productService.updateProduct(updateProductDTO);
            return new ResponseEntity<>("Product update succesfully", HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
