package com.example.userservice.domain.user.controller;

import com.example.userservice.domain.user.dto.request.CreateUserRequestDto;
import com.example.userservice.domain.user.dto.response.UserResponseDto;
import com.example.userservice.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {
    private final UserService userService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in Use Service" +
                ", port(local.server.port)=" + env.getProperty("local.server.port") +
                ", port(server.port)=" + env.getProperty("server.port") +
                ", token secret=" + env.getProperty("token.secret") +
                ", token expiration time=" + env.getProperty("token.expiration_time"));
    }

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
