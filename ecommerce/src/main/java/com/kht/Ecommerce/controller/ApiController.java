package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.dto.Products;
import com.kht.Ecommerce.dto.User;
import com.kht.Ecommerce.service.*;
import com.kht.Ecommerce.vo.CartProductsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    public ApiController() {
        userService = new UserServiceImpl();
        cartService = new CartServiceImpl();
        productService = new ProductServiceImpl();
    }

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    // 사용자 목록 API
    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // 상품 목록 API
    @GetMapping("/api/products")
    public List<Products> getProducts() {
        return productService.getAllProducts();
    }

    // 특정 사용자의 장바구니 API
    // http://loaclhost:8080/api/carts?userId=${userId}
    @GetMapping("/api/carts")
    public List<Cart> getCart(@RequestParam("userId") int userId) {
        return cartService.getCartByUserId(userId);
    }

    /*
        HTTP Status 500

     */
    @GetMapping("/cart{userId}")
    public String getCartById(@PathVariable("userId") int id) {
        return "cart";
    }
}
