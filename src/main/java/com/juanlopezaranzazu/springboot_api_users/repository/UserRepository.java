package com.juanlopezaranzazu.springboot_api_users.repository;

import com.juanlopezaranzazu.springboot_api_users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // obtener usuario por username
    Optional<User> findByUsername(String username);
}
