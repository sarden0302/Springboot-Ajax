package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void insertUser(User user);

    boolean existByEmail(String email);
    //Map<String, Object> existByEmail(String email);

    User getUsersById(int id);
}
