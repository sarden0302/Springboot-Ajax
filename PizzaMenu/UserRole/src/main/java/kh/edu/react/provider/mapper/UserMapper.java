package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // User Login
    User getUserById(String userId);

    // Get User Info after login
    User loginUser(String userId, String userPassword);

    // 유저 이름으로 검색되는 유저 검색하기
    List<User> findUserByName(String userName);
}
