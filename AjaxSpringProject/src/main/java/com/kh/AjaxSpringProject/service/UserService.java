package com.kh.AjaxSpringProject.service;

import com.kh.AjaxSpringProject.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserId(int id);
}
