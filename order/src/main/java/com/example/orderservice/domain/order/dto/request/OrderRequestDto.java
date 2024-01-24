package com.example.orderservice.domain.order.dto.request;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
}
