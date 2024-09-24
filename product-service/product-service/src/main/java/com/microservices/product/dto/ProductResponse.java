package com.microservices.product.dto;

import java.math.BigDecimal;

public record ProductResponse(long id, String name, String description, BigDecimal price) {
}
