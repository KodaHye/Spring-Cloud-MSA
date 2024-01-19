package com.example.orderservice.domain.order.service;

import com.example.orderservice.domain.order.dto.request.OrderRequestDto;
import com.example.orderservice.domain.order.dto.response.OrderResponseDto;
import com.example.orderservice.domain.order.entity.OrderEntity;
import com.example.orderservice.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderDetails) {
        return null;
    }

    @Override
    public OrderResponseDto getOrderByOrderId(String orderId) {
        return new OrderResponseDto(orderRepository.findByOrderId(orderId));
    }

    @Override
    public List<OrderResponseDto> getOrderByUserId(String userId) {
        return orderRepository.findByUserId(userId)
                .stream().map(OrderResponseDto::new).collect(Collectors.toList());
    }
}
