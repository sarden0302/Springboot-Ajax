package kh.edu.social_members.service;

import kh.edu.social_members.dto.Member;
import kh.edu.social_members.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public void insertMember(String nickname, String username, String password, String email) {
        memberMapper.insertMember(nickname, username, password, email);
    }
}
