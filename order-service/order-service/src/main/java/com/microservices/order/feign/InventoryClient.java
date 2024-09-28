package com.microservices.order.feign;

//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


//*** Instead of feign client for sevice communication, We use REST Client because feign is not actively maintained now

//@FeignClient(value = "inventory", url="${inventory.url}")
public interface InventoryClient {

//    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    //The implementation of this interface is in config/RESTClientConfig
}
