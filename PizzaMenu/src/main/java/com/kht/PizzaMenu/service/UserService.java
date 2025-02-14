package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.model.dto.User;

public interface UserService {


    User findUserId(String userId);
    User loginUser(String userId, String password);
}
