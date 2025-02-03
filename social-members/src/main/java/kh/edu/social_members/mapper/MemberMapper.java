package kh.edu.social_members.mapper;

import kh.edu.social_members.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(String nickname, String username, String password, String email);
}
