package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.dto.Products;
import com.kht.Ecommerce.dto.User;
import com.kht.Ecommerce.service.*;
import com.kht.Ecommerce.vo.CartProductsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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
        Param = Parameter
        @RequestParam   : 부분적으로 저장할 때 사용
        @RequestBody    : 전체적으로 저장할 때 사용
     */
    @PostMapping("/api/join")
    public void join(@RequestBody User user) {
        userService.insertUser(user);
    }

    @GetMapping("/api/existEmail")
    public boolean existEmail(@RequestParam("email") String email) {
        /*
        boolean exists = userService.existByEmail(email);
        Map<String, Object> map = new HashMap<>();
        map.put("exists", exists);
        if (exist) {
        } else {
        }
        return map;
         */
        return userService.existByEmail(email);
    }

    @PostMapping("/api/products/insert")
    public void addProduct(@RequestBody Products products) {
        log.info("add product : {}", products);
        productService.addProduct();
    }

    @GetMapping("/api/user/{id}")
    public User apiUserById(@PathVariable("id") int id) {
        return userService.getUsersById(id);
    }

    // 사용자 수정하기 api
    // /api/user/edit/{id}
    @PutMapping("/api/user/edit/{id}")
    //                   경로 or 주소                   Body 에 작성된 데이터 param : 특정 부분만 전달
    public int editUser(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }

    @GetMapping("/api/products/{id}")
    public Products apiProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

}
