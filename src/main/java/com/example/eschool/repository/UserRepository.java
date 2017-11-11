package com.example.eschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eschool.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
