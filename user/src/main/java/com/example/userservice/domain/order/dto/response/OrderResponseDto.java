package com.example.userservice.domain.order.dto.response;

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
}
