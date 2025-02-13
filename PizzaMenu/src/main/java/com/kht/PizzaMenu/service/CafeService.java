package com.kht.PizzaMenu.service;

import com.kht.PizzaMenu.model.dto.Cafe;

import java.util.List;

public interface CafeService {
    List<Cafe> getAllCafes();
    Cafe getCafeById(int id);
    void addCafe(Cafe cafe);
}