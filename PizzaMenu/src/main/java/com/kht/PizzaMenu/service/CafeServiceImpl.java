package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.mapper.CafeMapper;
import com.kht.PizzaMenu.model.dto.Cafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeMapper cafeMapper;

    @Override
    public List<Cafe> getAllCafes() {
        return cafeMapper.selectAllCafes();
    }

    @Override
    public Cafe getCafeById(int id) {
        return cafeMapper.selectCafeById(id);
    }

    @Override
    public void addCafe(Cafe cafe) {
        cafeMapper.insertCafe(cafe);
    }
}