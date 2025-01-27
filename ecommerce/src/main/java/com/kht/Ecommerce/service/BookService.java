package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.KHTBook;

import java.util.List;

public interface BookService {

    List<KHTBook> findAll();

    KHTBook findById(int id);

    int insertBook(KHTBook book);

    int updateBook(KHTBook book);
}
