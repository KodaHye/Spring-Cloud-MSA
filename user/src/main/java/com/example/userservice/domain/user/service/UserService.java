package com.example.userservice.domain.user.service;

import com.example.userservice.domain.user.dto.request.CreateUserRequestDto;
import com.example.userservice.domain.user.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserResponseDto createUser(CreateUserRequestDto userRequestDto);
    List<UserResponseDto> getUserByAll();
    UserResponseDto getUserByUserId(String userId);
}
