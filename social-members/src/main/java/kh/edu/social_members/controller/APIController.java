package kh.edu.social_members.controller;

import kh.edu.social_members.dto.Member;
import kh.edu.social_members.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class APIController {

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping("/signup")
    public void signup(@RequestParam("nickname") String nickname,
                       @RequestParam("username") String username,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password) {

        log.info("postMapping : " + nickname + ", " + username + ", " + email + ", " + password);
        memberService.insertMember(nickname, username, email, password);
    }
}
