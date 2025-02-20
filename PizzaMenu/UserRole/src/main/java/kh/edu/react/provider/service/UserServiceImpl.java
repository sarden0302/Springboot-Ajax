package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;
import kh.edu.react.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        User user = userMapper.getUserById(userId);
        System.out.println("=============== Service =================");
        System.out.println("user : " + user);

        return user;
    }

    /*
    Map <   KEY, VALUE>   -> Java 에서 key-value 쌍을 저장하는 자료구조
    Map <String, Object>  -> String 문자열 타입의 key 를 사용하고, value 를 저장할 다양한 데이터 타입을 한번에 저장할 때 용이
                             Value 값에 Object 로 작성하는 것은
                             어떤 타입이든 저장 가능 (Integer, String, List, User... etc)
                             Object 를 사용하면 아래처럼 단일 문자만 저장하는 것이 아니라 인사말 키에서 장르별로 값을 목록화하여 저장할 수 있음
                             데이터를 가져올 때 에러 최소화 가능
    Map <String, String>  -> 문자열 - 문자열 만 저장 가능
    Map <String, Integer> -> 문자열 - 숫자 만 저장 가능
                            ex) "인증번호" - 123456
    Map <Integer, Integer> -> 숫자형 - 숫자형만 저장 가능
                            ex)    1     - 56789
     */
    @Override
    public Map<String, Object> loginUser(String userId, String userPassword) {
        User loggedInUser = userMapper.loginUser(userId, userPassword);
        Map<String, Object> result = new HashMap<String, Object>();

        if (loggedInUser != null) {
            result.put("status", "success");
            result.put("user", loggedInUser);
            result.put("redirect", "/");

            // 유저 롤에 따라 페이지 설정 유저, 기업, 관리자로 이동 설정

        } else {
            result.put("status", "fail");
            result.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }


        System.out.println("result : " + result);
        System.out.println("loggedInUser : " + loggedInUser);
        return result;
    }

    @Override
    public List<User> findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }
}
