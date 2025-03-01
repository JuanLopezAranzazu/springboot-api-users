package com.juanlopezaranzazu.springboot_api_users.service;

import com.juanlopezaranzazu.springboot_api_users.dto.UserResponse;
import com.juanlopezaranzazu.springboot_api_users.entity.User;
import com.juanlopezaranzazu.springboot_api_users.exception.ResourceNotFoundException;
import com.juanlopezaranzazu.springboot_api_users.repository.UserRepository;
import com.juanlopezaranzazu.springboot_api_users.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // obtener el usuario autenticado
    public UserResponse getUser() {
        // obtener el username del usuario
        String username = AuthUtil.getAuthenticatedUsername();
        // obtener el usuario
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        return UserResponse.fromEntity(user);
    }
}
