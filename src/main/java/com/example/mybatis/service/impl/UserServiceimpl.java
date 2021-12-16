package com.example.mybatis.service.impl;


import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User getUserById(int userId) {
        return userMapper.getById(userId);
    }

    public User getUserName(String username) {
        return userMapper.getUserName(username);
    }

}