package com.example.userservice.service;

import com.example.userservice.dto.request.CreateUserRequestDto;
import com.example.userservice.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponseDto createUser(CreateUserRequestDto userRequestDto);
}
