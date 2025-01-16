package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.service.UserService;
import com.kh.AjaxSpringProject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Ajax 와 별개로 /detail/ 원하는 회원 정보 번호를 통해서
    // detail.html 을 보여줄 수 있도록 설정하는 Controller
    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id) {
        return "userInfo";
    }

    @GetMapping("/get/avatar")
    public String getAvata() {
        return "jqueryAjax/Avatar";
    }

    @GetMapping("/get/randomLogo")
    public String getRandomLogo() {
        return "jqueryAjax/randomLogo";
    }

    @GetMapping("/get/product")
    public String getProduct() {
        return "jqueryAjax/product";
    }

    @GetMapping("/get/kakaoLogin")
    public String getKakaoLogin() {
        return "jqueryAjax/kakaoLogin";
    }
}
