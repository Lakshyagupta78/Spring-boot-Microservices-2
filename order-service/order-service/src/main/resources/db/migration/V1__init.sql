CREATE TABLE IF NOT EXISTS t_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_no VARCHAR(255) DEFAULT NULL,
    sku_code VARCHAR(255),
    price DECIMAL(10, 2),
    quantity INT
);

