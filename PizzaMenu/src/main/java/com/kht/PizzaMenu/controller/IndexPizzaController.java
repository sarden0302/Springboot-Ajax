package com.kht.PizzaMenu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPizzaController {

    @GetMapping("/")
    public String index() {
        // 피자 목록 조회
        return "index";
    }
}
