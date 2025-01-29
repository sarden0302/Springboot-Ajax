package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.PizzaMenuMapper;
import com.kht.PizzaMenu.model.dto.PizzaMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaMenuServiceImpl implements PizzaMenuService{

    @Autowired
    PizzaMenuMapper pizzaMenuMapper;

    @Override
    public List<PizzaMenu> getAllPizzaMenu() {
        return pizzaMenuMapper.getAllPizzaMenu();
    }

    @Override
    public PizzaMenu getPizzaMenuById(int id) {
        return pizzaMenuMapper.getPizzaMenuById(id);
    }
}
