package com.juanlopezaranzazu.springboot_api_users.config;

import com.juanlopezaranzazu.springboot_api_users.entity.Role;
import com.juanlopezaranzazu.springboot_api_users.entity.User;
import com.juanlopezaranzazu.springboot_api_users.repository.RoleRepository;
import com.juanlopezaranzazu.springboot_api_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@Order(2)
public class AdminInitializer implements CommandLineRunner {
    @Value("${admin.name}")
    private String adminName;
    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    // crear usuario ADMIN por defecto
    @Override
    public void run(String... args) {
        // verificar si ya existe un usuario admin
        Optional<User> adminUser = userRepository.findByUsername(adminUsername);
        if (adminUser.isEmpty()) {
            User newUser = new User();
            newUser.setName(adminName);
            newUser.setUsername(adminUsername);
            // encriptar contraseña
            newUser.setPassword(bCryptPasswordEncoder.encode(adminPassword));

            // obtener el rol admin
            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Rol ADMIN no encontrado"));
            // asignar rol
            newUser.setRoles(Set.of(adminRole));
            userRepository.save(newUser);
            System.out.println("Usuario ADMIN creado");
        }
    }
}
