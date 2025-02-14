package com.kht.PizzaMenu.controller;

import com.kht.PizzaMenu.model.dto.User;
import com.kht.PizzaMenu.service.UserService;
import com.kht.PizzaMenu.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {

    @Autowired
    private UserServiceImpl userService;

    // login
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user, HttpSession session) {
        User loginUser = userService.loginUser(user.getUserId(), user.getPassword());

        Map<String, Object> response = new HashMap<>();
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            response.put("status", "success");
            response.put("user", loginUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "fail");
            response.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return ResponseEntity.status(401).body(response);
        }
    }

    // logout

    // checking whether login or not

    // MyPage

    //

}
