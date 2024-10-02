package com.microservices.order.service;

import com.microservices.order.dto.OrderRequest;
import com.microservices.order.feign.InventoryClient;
import com.microservices.order.model.Order;
import com.microservices.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo or;

    @Autowired
    private InventoryClient ic;

    public void placeOrder(OrderRequest orderRequest){

        boolean isProductInStock = ic.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock){
        Order order = new Order();
        order.setOrder_no(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        or.save(order);
        }//else{
//            throw new RuntimeException("Product is not in stock");
//        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product is not in stock");
        }
    }
}
