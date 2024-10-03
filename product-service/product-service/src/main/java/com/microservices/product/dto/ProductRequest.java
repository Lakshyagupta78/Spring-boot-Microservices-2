package com.microservices.product.dto;

import org.bson.types.ObjectId;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price, int quantity) {
}
