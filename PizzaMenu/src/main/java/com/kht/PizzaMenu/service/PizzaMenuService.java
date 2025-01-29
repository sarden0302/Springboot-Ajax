package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.PizzaMenuMapper;
import com.kht.PizzaMenu.model.dto.PizzaMenu;

import java.util.List;

public interface PizzaMenuService {
    List<PizzaMenu> getAllPizzaMenu();

    PizzaMenu getPizzaMenuById(int id);
}
