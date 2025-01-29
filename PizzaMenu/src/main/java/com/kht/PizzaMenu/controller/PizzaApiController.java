package com.kht.PizzaMenu.controller;

import com.kht.PizzaMenu.model.dto.PizzaMenu;
import com.kht.PizzaMenu.service.PizzaMenuService;
import com.kht.PizzaMenu.service.PizzaMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PizzaApiController {

    @Autowired
    PizzaMenuServiceImpl pizzaMenuService;

    @GetMapping("/pizzamenu")
    public List<PizzaMenu> getPizzaMenu() {
        return pizzaMenuService.getAllPizzaMenu();
    }

    @GetMapping("/pizza/{id}")
    public PizzaMenu getPizza(@PathVariable("id") int id) {
        return pizzaMenuService.getPizzaMenuById(id);
    }
}
