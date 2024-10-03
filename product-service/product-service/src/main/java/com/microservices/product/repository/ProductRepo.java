package com.microservices.product.repository;

import com.microservices.product.model.Product;
//import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product, String> {

}
