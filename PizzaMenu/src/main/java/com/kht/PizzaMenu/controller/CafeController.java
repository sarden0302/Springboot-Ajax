package com.kht.PizzaMenu.controller;

import com.kht.PizzaMenu.model.dto.Cafe;
import com.kht.PizzaMenu.service.CafeService;
import com.kht.PizzaMenu.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    @Autowired
    private CafeServiceImpl cafeService;

    // 모든 카페 조회
    @GetMapping
    public List<Cafe> getAllCafes() {
        return cafeService.getAllCafes();
    }

    // 특정 카페 조회
    @GetMapping("/{id}")
    public Cafe getCafeById(@PathVariable int id) {
        return cafeService.getCafeById(id);
    }

    // 새로운 카페 추가
    @PostMapping
    public void addCafe(@RequestBody Cafe cafe) {
        cafeService.addCafe(cafe);
    }
}