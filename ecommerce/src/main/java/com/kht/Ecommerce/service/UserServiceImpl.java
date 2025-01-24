package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.User;
import com.kht.Ecommerce.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // SecurityConfig 내부에 @Bean 태그로 설정한 BCrypto 호출해서 비밀번호 암호화 사용
    @Autowired  // @Autowired : 다른 곳에서 작성된 속성이나 객체 파일을 호출하기
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void insertUser(User user) {
        System.out.println("html -> controller -> service 로 가져온 비밀번호 확인 : " + user.getPassword());
        System.out.println("가져온 비밀번호 암호화" + passwordEncoder.encode(user.getPassword()));
        // khtUser.getPassword() => khtUser 유저에 저장하고자 html 에서 작성한 비밀번호 가져오기
        // passwordEncoder.encode(khtUser.getPassword()) => 가져온 비밀번호 암호화
        // khtUser.setPassword => 암호화된 비밀번호를 DB에 저장
        String encodePassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));   // 복구 불가능

        System.out.println("암호화 완료된 비밀번호 확인 : " + encodePassword); // 위에서 작성한 암호 확인하기
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
