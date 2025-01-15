package com.kh.AjaxSpringProject.service;

import com.kh.AjaxSpringProject.dto.Cafe;
import com.kh.AjaxSpringProject.mapper.CafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CafeServiceImpl implements CafeService{

    @Autowired
    CafeMapper cafeMapper;

    @Override
    public List<Cafe> getAllCafes() {
        return cafeMapper.getAllCafes();
    }
}
