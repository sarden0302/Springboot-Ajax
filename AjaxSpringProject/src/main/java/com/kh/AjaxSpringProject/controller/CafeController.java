package com.kh.AjaxSpringProject.controller;

import com.kh.AjaxSpringProject.dto.Cafe;
import com.kh.AjaxSpringProject.service.CafeService;
import com.kh.AjaxSpringProject.service.CafeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CafeController {

    public CafeController() {
        cafeService = new CafeServiceImpl();
    }

    @Autowired
    private CafeService cafeService;

    @GetMapping("/all/cafe")
    public String cafe() {
        return "cafe";
    }

    @GetMapping("/cafe")
    public String detail(@RequestParam("id") int id) {
        return "cafeDetail";
    }

    @RequestMapping(value = "/recafeInfo", method={RequestMethod.POST, RequestMethod.GET})
    public String recafeInfo(@PathVariable("id") int id, Model model) {
        System.out.println("recafeInfo , id = " + id );
        Cafe cafe = cafeService.getCafeById(id);
        model.addAttribute("cafe", cafe);
        return "recafeInfo";
    }
}
