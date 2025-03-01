package com.juanlopezaranzazu.springboot_api_users.dto;

import com.juanlopezaranzazu.springboot_api_users.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String username;

    // mostrar los datos del usuario
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getUsername()
        );
    }
}
