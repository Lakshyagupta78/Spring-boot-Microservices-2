package com.microservices.order.controller;

import com.microservices.order.dto.OrderRequest;
import com.microservices.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService os;

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        os.placeOrder(orderRequest) ;
        return "Order Placed Successfully";
    }
}
