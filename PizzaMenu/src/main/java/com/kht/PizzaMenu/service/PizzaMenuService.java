package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.PizzaMenuMapper;
import com.kht.PizzaMenu.model.dto.PizzaMenu;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// Service interface 는 어떤 자료형 / 어떤 매개변수를 이용해서 메서드 목록이 작성되어 있는지에 대한 목록
public interface PizzaMenuService {
    List<PizzaMenu> getAllPizzaMenu();

    PizzaMenu getPizzaMenuById(int id);

    void insertPizzaMenu(String name, int price, String description, MultipartFile file);

    int updatePizzaMenu(String name, int price, String description, MultipartFile file, PizzaMenu pizzaMenu);

    int deleteById(int id);
}
