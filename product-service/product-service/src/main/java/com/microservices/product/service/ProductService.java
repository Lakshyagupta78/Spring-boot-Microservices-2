package com.microservices.product.service;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.dto.ProductResponse;
import com.microservices.product.model.Product;
import com.microservices.product.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepo pr;


    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description((productRequest.description()))
                .price(productRequest.price())
                .quantity(productRequest.quantity())
                .build();
        try {
            pr.save(product);
            log.info("Product Created Successfully");
            return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity());
        } catch (Exception e) {
            log.error("Error creating product: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create product");
        }
    }


    public List<ProductResponse> getAllProducts() {
        return pr.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity()))
                .toList();
    }
}
