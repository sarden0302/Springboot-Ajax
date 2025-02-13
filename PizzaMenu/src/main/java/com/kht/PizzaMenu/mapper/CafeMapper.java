package com.kht.PizzaMenu.mapper;

import com.kht.PizzaMenu.model.dto.Cafe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CafeMapper {
    List<Cafe> selectAllCafes();
    Cafe selectCafeById(int id);
    void insertCafe(Cafe cafe);
}