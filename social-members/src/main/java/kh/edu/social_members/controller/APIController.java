package kh.edu.social_members.controller;

import kh.edu.social_members.dto.Member;
import kh.edu.social_members.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping("/signup")
    public void signup(@RequestBody Member member) {
        memberService.insertMember(member);
    }
}
