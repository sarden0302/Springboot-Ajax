package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.KHTBook;
import com.kht.Ecommerce.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookMapper bookMapper;

    @Value("D://Leo/SoftwareEngineering/book-image-path/images/books") // application.properties 에 작성한 이미지 경로 가져옴
    private String uploadBookImg;

    @Override
    public List<KHTBook> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public KHTBook findById(int id) {
        return bookMapper.findById(id);
    }

    @Override
    public void insertBook(String title, String author, String genre, MultipartFile file) {
        String filename = System.currentTimeMillis() + "_ " +  file.getOriginalFilename();

        //                          경로   + 파일명칭
        File saveFile = new File(uploadBookImg, filename);

        // 1. 이미지 저장하기
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            System.out.println("이미지 저장 실패!");
        }
        // 2. 이미지 경로 String 타입으로 저장하기
        KHTBook khtBook = new KHTBook();
        khtBook.setTitle(title);
        khtBook.setAuthor(author);
        khtBook.setGenre(genre);
        khtBook.setImagePath("/images/" + filename);

        bookMapper.insertBook(khtBook);
    }

    @Override
    public int updateById(KHTBook book) {
        return 0;
    }
}
