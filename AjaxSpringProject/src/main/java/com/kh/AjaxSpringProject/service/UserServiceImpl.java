package com.kh.AjaxSpringProject.service;

import com.kh.AjaxSpringProject.dto.User;
import com.kh.AjaxSpringProject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserId(int id) {
        return userMapper.getUserId(id);
    }
}
