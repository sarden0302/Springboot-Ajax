package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.dto.Cafe;
import com.kh.AjaxSpringProject.service.CafeService;
import com.kh.AjaxSpringProject.service.CafeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CafeAjaxController {

    CafeAjaxController() {
        cafeService = new CafeServiceImpl();
    }

    @Autowired
    private CafeService cafeService;

    @GetMapping("/api/cafes")
    public List<Cafe> getAllCafes() {
        return cafeService.getAllCafes();
    }

    @GetMapping("/api/cafes/{id}")
    public Cafe getCafe(@PathVariable("id") int id) {
        return cafeService.getCafeById(id);
    }
}
