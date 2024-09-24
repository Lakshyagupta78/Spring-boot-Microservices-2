package com.microservices.order.dto;


import java.math.BigDecimal;

public record OrderRequest(long id, String order_no, String sku_Code, BigDecimal price, Integer quantity) {
}
