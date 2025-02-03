package kh.edu.social_members.service;

import kh.edu.social_members.dto.Member;

public interface MemberService {
    void insertMember(String nickname, String username, String password, String email);
}
