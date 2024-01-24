package com.example.orderservice.domain.order.controller;

import com.example.orderservice.domain.order.dto.request.OrderRequestDto;
import com.example.orderservice.domain.order.dto.response.OrderResponseDto;
import com.example.orderservice.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order-service")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{userId}/orders")
    public ResponseEntity<OrderResponseDto> createOrder(@PathVariable("userId") String userId,
                                                        @RequestBody OrderRequestDto orderDetails) {

        OrderResponseDto returnValue = orderService.createOrder(orderDetails, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping("{userId}/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrder(@PathVariable("userId") String userId) {
        List<OrderResponseDto> result = orderService.getOrderByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
