package com.juanlopezaranzazu.springboot_api_users.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private List<String> roles; // nombre de los roles del usuario
}
