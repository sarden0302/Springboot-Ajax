package com.kht.PizzaMenu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewController {

    @Value("${kakao.javascript.app.key}")
    private String kakaoJSAppKey;

    @GetMapping("/")
    public String index() {
        // 피자 목록 조회
        return "index";
    }

    @GetMapping("/kakao/map")
    public String map(Model model) {
        model.addAttribute("appKey", kakaoJSAppKey);
        return "kakaoMap";
    }
}
