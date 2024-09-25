package com.microservices.inventory.service;

import com.microservices.inventory.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepo ir;

    public boolean isInStock(String skuCode, Integer quantity){

       return ir.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
