package com.microservices.inventory.controller;

import com.microservices.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService is;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return is.isInStock(skuCode,quantity);
    }
}
