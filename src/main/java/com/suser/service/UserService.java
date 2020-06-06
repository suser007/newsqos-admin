package com.suser.service;

import com.suser.entity.User;
import com.suser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findByUser(User user){
        return userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String id){
        return userMapper.findUserById(id);
    }
}
