package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.User;
import com.kht.Ecommerce.mapper.UserMapper;
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
    public void insertUser(User user) {
        userMapper.insertUser(user); // return 필요 없음
    }

    @Override
    public boolean existByEmail(String email) {

        return userMapper.existByEmail(email) > 0;
    }

    @Override
    public User getUsersById(int id) {
        return userMapper.getUsersById(id);
    }
}
