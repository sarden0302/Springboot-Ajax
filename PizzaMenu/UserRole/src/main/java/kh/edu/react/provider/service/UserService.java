package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;

// 서비스 목록
public interface UserService {

    // User Login
    User getUserById(String userId);

    // Get User Info after login
    User loginUser(String userId, String userPassword);
}
