package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.KHTBook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {

    List<KHTBook> findAll();

    KHTBook findById(int id);

    void insertBook(String title, String author, String genre, MultipartFile file);

    int updateById(KHTBook book);
}
