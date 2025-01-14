package com.kh.AjaxProject.service;

import com.kh.AjaxProject.DTO.Member;
import com.kh.AjaxProject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    // Field injection is not recommended
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> getAllMembers() {
        return memberMapper.getAllMembers();
    }
}
