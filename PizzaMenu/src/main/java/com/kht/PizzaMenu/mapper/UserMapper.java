package com.kht.PizzaMenu.mapper;

import com.kht.PizzaMenu.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    // 유저 로그인 유저 정보를 가져올 것
    User findUserId(String userId);
    User loginUser(String userId, String password);
    /*
        만약에 명칭이 다를 경우
        컬럼명 / 변수명   /   파       라       미       터   명칭  / name 에 작성한 변수이름 또는 상태 관리 명칭
        SQL -> DTO 명칭 -> Mapper -> ServiceImpl -> Controller -> Html or JavaScript
        에서 명칭이 다른 것끼리 전달하려 하지 않았는지 확인

        User findUserId(@Param("userId") String userId);
        User loginUser(@Param("userId") String userId, @Param("password") String password);
     */

}
