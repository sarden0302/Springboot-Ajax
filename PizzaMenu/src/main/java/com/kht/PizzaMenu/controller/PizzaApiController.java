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

    // RequestPart @RequestParam
    /* /pizza/edit
        /pizza PUT
        /pizza POST
        /pizza DELETE
     */

    @PutMapping("/pizza/edit/{id}")
    public int editPizza(@PathVariable("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("price") int price,
                         @RequestParam("description") String description,
                         @RequestParam(value = "imagePath", required = false) MultipartFile imagePath) {
                        // required = false  :  @RequestParam 요청으로 프론트앤드에서 값을 가져올 때 null 값이어도 가능
                        // default -> true
                        // DB 에서 not null 일 경우 required 를 true 로 줌  null(nullable) 일 경우  required = false 작성해줌
        /*
            Controller 는 주로 Backend <-> Frontend 중간 다리 역할
            똑같으 URL API 주소에서는 GET POST PUT DELETE 최초 1회씩만 사용 가능
            Controller
              1. frontend 에서 가져온 데이터 @Service 전달
              2. DB 에서 Backend 로 가져온 데이터 @Service 로 전달
         */
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
