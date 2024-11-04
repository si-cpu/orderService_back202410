package com.spring.orderservice_back202410.user.repository;


import com.spring.orderservice_back202410.user.entity.User;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}