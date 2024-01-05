package com.example.userservice.controller;

import com.example.userservice.dto.request.CreateUserRequestDto;
import com.example.userservice.dto.response.UserResponseDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
