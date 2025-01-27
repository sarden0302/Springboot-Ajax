package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.KHTBook;
import com.kht.Ecommerce.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookMapper bookMapper;


    @Override
    public List<KHTBook> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public KHTBook findById(int id) {
        return bookMapper.findById(id);
    }

    @Override
    public int insertBook(KHTBook book) {

        return 0;
    }

    @Override
    public int updateBook(KHTBook book) {
        return 0;
    }
}
