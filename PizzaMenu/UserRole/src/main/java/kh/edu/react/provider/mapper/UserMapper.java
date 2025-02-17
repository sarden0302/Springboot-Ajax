package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // User Login
    User getUserById(String userId);

    // Get User Info after login
    User loginUser(String userId, String userPassword);
}
