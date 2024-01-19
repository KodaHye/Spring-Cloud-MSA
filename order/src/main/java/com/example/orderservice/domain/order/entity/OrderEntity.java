package com.example.orderservice.domain.order.entity;

import com.example.orderservice.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 120)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;
}
