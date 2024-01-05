package com.example.userservice.dto.response;

import com.example.userservice.entity.UserEntity;
import lombok.Data;

@Data
public class UserResponseDto {
    private String email;
    private String name;
    private String userId;

    public UserResponseDto(UserEntity user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
    }
}
