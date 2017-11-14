package com.example.eschool.service;

import com.example.eschool.mapper.UsersMapper;
import com.example.eschool.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersMapper.insert(user);
    }

    @Override
    public User findByUsername(String username) {
        return usersMapper.findByUsername(username);
    }
}
