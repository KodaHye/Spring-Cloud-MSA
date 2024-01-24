package com.example.orderservice.domain.order.dto.response;

import com.example.orderservice.domain.order.entity.OrderEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponseDto {
    private String orderId;
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;

    public OrderResponseDto(OrderEntity order) {
        this.orderId = order.getOrderId();
        this.productId = order.getProductId();
        this.qty = order.getQty();
        this.unitPrice = order.getUnitPrice();
        this.totalPrice = order.getTotalPrice();
        this.createdAt = order.getCreatedAt();
    }
}
