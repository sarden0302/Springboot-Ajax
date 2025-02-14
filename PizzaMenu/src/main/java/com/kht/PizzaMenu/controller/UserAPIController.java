package com.kht.PizzaMenu.controller;

import com.kht.PizzaMenu.model.dto.User;
import com.kht.PizzaMenu.service.UserService;
import com.kht.PizzaMenu.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/logout")
    public ResponseEntity<Map<String, Object>> logoutUser(HttpSession session) {
        session.invalidate();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "logout");
        return ResponseEntity.status(200).body(response);
    }


    // checking whether login or not
    @GetMapping("/checkLogin")
    public ResponseEntity<?> checkLogin(HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        if (loginUser != null) {
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "로그인 상태가 이닙니다."));
        }
    }

    // MyPage
    @GetMapping("/{userId}")
    public ResponseEntity<?> findUserId(@PathVariable("userId") String userId) {
        User user = userService.findUserId(userId);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(Map.of("status", "로그인 상태가 아닙니다."));
        }
    }

    //

}
