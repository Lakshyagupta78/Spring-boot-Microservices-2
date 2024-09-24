package com.microservices.product.controller;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.dto.ProductResponse;
import com.microservices.product.model.Product;
import com.microservices.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ps;

    @PostMapping("/Create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest product){
        return ps.createProduct(product);
    }

    @GetMapping("/AllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> allProduct(){
        return ps.getAllProducts();
    }
}
