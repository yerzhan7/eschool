package com.example.eschool.service;

import com.example.eschool.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
