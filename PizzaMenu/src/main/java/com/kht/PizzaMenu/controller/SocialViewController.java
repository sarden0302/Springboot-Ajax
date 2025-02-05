package com.kht.PizzaMenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SocialViewController {

    // 카카오 네이버 로그인 html  연결
    // IndexViewController 에서 index.html 내 카카오 네이버 로그인 버튼 설정

    // 카카오 회원가입 html 연결
    @GetMapping("/signup/kakao")
    public String kakaoSignup(@RequestParam("nickname") String nickname,
                              @RequestParam("email") String email,
                              @RequestParam("profileImg") String profileImg,
                              @RequestParam("gender") String gender,
                              @RequestParam("birthday") String birthday,
                              Model model) {
        return "signup/kakao";
    }

    // 네이버 회원가입 html 연결
    @GetMapping("/signup/naver")
    public String naverSignup(@RequestParam("nickname") String nickname,
                              @RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("gender") String gender,
                              @RequestParam("profileImage") String profileImage,
                              @RequestParam("birthday") String birthday) {
        return "signup/naver";
    }
}
