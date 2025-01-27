package com.kht.Ecommerce.mapper;

import com.kht.Ecommerce.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // DB 에서 데이터 가져올 때만 DTO 사용
    // 사용자 전체 조회
    List<User> getAllUsers();

    // 신규 사용자 저장
    // insert 1개일 경우나 갯수 상관이 없다면 void
    // 여러개 column 을 동시에 입력 시 몇 개 추가했는지 갯수 반환
    void insertUser(User user);

    // 이메일 존재 유무 확인
    // MySQL 에선 true false 가 1, 0
    int existByEmail(String email);

    User getUsersById(int id);

    // int -> update 와 insert 를 여러개를 수정 시 갯수가 출력
    // POST or PUT or ... = 몇 개 DB에 변화를 주었는지     &&      GET = 몇 개 찾았는지
    int updateUser(User user);
}
