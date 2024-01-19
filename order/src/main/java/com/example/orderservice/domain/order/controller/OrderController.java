package com.example.orderservice.domain.order.controller;

import com.example.orderservice.domain.order.dto.request.OrderRequestDto;
import com.example.orderservice.domain.order.dto.response.OrderResponseDto;
import com.example.orderservice.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable("userId") String userId,
                                                        @RequestBody OrderRequestDto orderDetails) {

        OrderResponseDto returnValue = orderService.createOrder(orderDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
