package com.juanlopezaranzazu.springboot_api_users.controller;

import com.juanlopezaranzazu.springboot_api_users.dto.AuthRequest;
import com.juanlopezaranzazu.springboot_api_users.dto.AuthResponse;
import com.juanlopezaranzazu.springboot_api_users.dto.UserRequest;
import com.juanlopezaranzazu.springboot_api_users.dto.UserResponse;
import com.juanlopezaranzazu.springboot_api_users.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    // login de usuarios
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    // registro de usuarios
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserResponse> register(
            @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authService.register(userRequest));
    }
}
