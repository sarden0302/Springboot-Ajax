package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.dto.Product;
import com.kht.Ecommerce.dto.User;
import com.kht.Ecommerce.service.CartService;
import com.kht.Ecommerce.service.ProductService;
import com.kht.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    // 사용자 목록 API
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return null;
    }

    // 상품 목록 API
    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return null;
    }

    // 특정 사용자의 장바구니 API
    @GetMapping("/api/carts")
    public Cart getCart() {
        return null;
    }
}
