package com.example.orderservice.domain.order.service;

import com.example.orderservice.domain.order.dto.request.OrderRequestDto;
import com.example.orderservice.domain.order.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderDetails, String userId);
    OrderResponseDto getOrderByOrderId(String orderId);
    List<OrderResponseDto> getOrderByUserId(String userId);
}
