package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "userInfo";
    }
}
