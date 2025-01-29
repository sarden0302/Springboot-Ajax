package com.kht.PizzaMenu.mapper;

import com.kht.PizzaMenu.model.dto.PizzaMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PizzaMenuMapper {

    List<PizzaMenu> getAllPizzaMenu();

    PizzaMenu getPizzaMenuById(int id);
}
