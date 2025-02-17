package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;

import java.util.Map;

// 서비스 목록
public interface UserService {

    // User Login
    User getUserById(String userId);

    // Get User Info after login
    Map<String, Object> loginUser(String userId, String userPassword);
}
