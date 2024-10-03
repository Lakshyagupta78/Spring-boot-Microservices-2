package com.microservices.product.dto;

//import org.bson.types.ObjectId;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price, int quantity) {
}
