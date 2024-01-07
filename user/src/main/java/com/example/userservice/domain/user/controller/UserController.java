package com.example.userservice.domain.user.controller;

import com.example.userservice.domain.user.dto.request.CreateUserRequestDto;
import com.example.userservice.domain.user.dto.response.UserResponseDto;
import com.example.userservice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto userRequestDto) {
        UserResponseDto user = userService.createUser(userRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getUserByAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> getUserByUserId(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserId(userId));
    }
}
