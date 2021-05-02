package com.example.springstart.repositories;

import com.example.springstart.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
