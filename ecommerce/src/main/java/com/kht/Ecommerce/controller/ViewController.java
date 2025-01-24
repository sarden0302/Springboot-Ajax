package com.kht.Ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    // 사용자 목록 페이지
    @GetMapping("/")
    public String usersPage() {
        return "index";
    }

    // 상품 목록 페이지
    @GetMapping("/products")
    public String productsPage() {
        return "products";
    }

    // 장바구니 페이지
    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    // 유저 장바구니 페이지
    @GetMapping("/cart{userId}")
    public String getCartById(@PathVariable("userId") int id) {
        return "cart";
    }

    // 회원가입 페이지
    @GetMapping("/join")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/products/insert")
    public String  getProduct() {
        return "insertProduct";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam("id") int id) {
        return "user_detail";
    }

    @GetMapping("/user/edit")
    public String editUserById(@RequestParam("id") int id) {
        return "user_edit";
    }

    @GetMapping("/products/")
    public String getProductById(@RequestParam("id") int id) {
        return "product_detail";
    }

    // RequestParam 은 url 에 작성 x
    @GetMapping("/update/products")
    public String updateProduct(@RequestParam("id") int id) {
        return "updateProduct";
    }

}
