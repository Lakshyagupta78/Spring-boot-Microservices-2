package com.microservices.order.service;

import com.microservices.order.dto.OrderRequest;
import com.microservices.order.model.Order;
import com.microservices.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo or;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrder_no(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSku_Code(orderRequest.sku_Code());
        order.setQuantity(orderRequest.quantity());
        or.save(order);
    }
}
