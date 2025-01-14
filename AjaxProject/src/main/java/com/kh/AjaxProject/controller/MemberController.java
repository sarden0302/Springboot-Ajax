package com.kh.AjaxProject.controller;

import com.kh.AjaxProject.DTO.Member;
import com.kh.AjaxProject.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@RestController// -> json backend 형식
@Controller
public class MemberController {
    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/testcode")
    public void testCode(Model model) {
        List<Member> members = memberService.getAllMembers();
        model.addAttribute("members", members);
    }

    // ResponseEntity : 데이터를 전달했는지 확인
    /**
     * ResponseEntity<></>
     * @return ResponseEntity.ok
     */

    @GetMapping("/api/member")
    public List<Member> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        System.out.println(members);
        return members;
    }
}
