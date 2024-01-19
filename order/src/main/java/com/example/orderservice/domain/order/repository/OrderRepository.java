package com.example.orderservice.domain.order.repository;

import com.example.orderservice.domain.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByUserId(String userId);

    OrderEntity findByOrderId(String orderId);
}
