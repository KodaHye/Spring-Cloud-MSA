package com.example.userservice.domain.user.dto.response;

import com.example.userservice.domain.order.dto.response.OrderResponseDto;
import com.example.userservice.domain.user.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {
    private String email;
    private String name;
    private String userId;
    private List<OrderResponseDto> orders;

    public UserResponseDto(UserEntity user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
    }

    public UserResponseDto(UserEntity user, List<OrderResponseDto> orders) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.orders = orders;
    }
}
