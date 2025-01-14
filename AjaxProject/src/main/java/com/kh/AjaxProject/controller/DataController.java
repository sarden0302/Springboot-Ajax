package com.kh.AjaxProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataController {
    @GetMapping("api/data")
    public ResponseEntity<Map<String, String>> getData(){
        Map<String, String> map = new HashMap<>();
        map.put("msg", "안녕하세요~~");
        map.put("status", "성공~~");
        return ResponseEntity.ok(map);
    }
}
