package com.kht.PizzaMenu.controller;

import com.kht.PizzaMenu.model.dto.PizzaMenu;
import com.kht.PizzaMenu.service.PizzaMenuService;
import com.kht.PizzaMenu.service.PizzaMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/pizza/edit/{id}")
    public int editPizza(@PathVariable("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("price") int price,
                         @RequestParam("description") String description,
                         @RequestParam("imagePath") MultipartFile imagePath) {
        PizzaMenu pizzaMenu = pizzaMenuService.getPizzaMenuById(id);
        pizzaMenu.setName(name);
        return pizzaMenuService.updatePizzaMenu(name, price, description, imagePath, pizzaMenu);
    }

    @PostMapping("/savePizzaMenu")
    public void savePizzaMenu(@RequestParam("name") String name,
                              @RequestParam("price") int price,
                              @RequestParam("description") String description,
                              @RequestParam("imagePath") MultipartFile imagePath) {
        pizzaMenuService.insertPizzaMenu(name, price, description, imagePath);
    }

    @DeleteMapping("/pizzamenu/delete/{id}")
    public int deletePizzaMenu(@PathVariable("id") int id) {
        return pizzaMenuService.deleteById(id);
    }
}
