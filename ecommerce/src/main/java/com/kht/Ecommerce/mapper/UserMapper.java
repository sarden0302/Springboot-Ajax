package com.kht.Ecommerce.mapper;

import com.kht.Ecommerce.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 사용자 전체 조회
    List<User> getAllUsers();

    // 신규 사용자 저장
    void insertUser(User user);

    // 이메일 존재 유무 확인
    // MySQL 에선 true false 가 1, 0
    int existByEmail(String email);

    User getUsersById(int id);

    void updateUser(User user);
}
