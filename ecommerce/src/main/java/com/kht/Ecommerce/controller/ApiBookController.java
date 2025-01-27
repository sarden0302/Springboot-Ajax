package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.KHTBook;
import com.kht.Ecommerce.service.BookService;
import com.kht.Ecommerce.service.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
public class ApiBookController {

    @Autowired
    private BookServiceImpl khtBookService;
    @Autowired
    private BookService bookService;

    @GetMapping("/bookList")
    public List<KHTBook> books() {
        return khtBookService.findAll();
    }

    @GetMapping("/books/{id}") // id 조회
    public KHTBook book(@PathVariable("id") int id) {
        return khtBookService.findById(id);
    }

    /* 기본 글자 타입만 한 번에 저장하기
     * @param khtBook = Body = 통째로 바디 내 세부 설정 없이 한 번에 가져온 그대로 저장
     * @return        = 저장 역할을 하는 save 로 데이터 그대로 전달
    @PostMapping("/bookSave")
    public KHTBook saveBook(@RequestBody KHTBook khtBook) {
        KHTBook savedBook = khtBookService.save(khtBook);
        log.info(savedBook.toString());
        return savedBook;
    }
    */
    @PostMapping("/bookSaveImg")
    public void saveBookImg(@RequestParam("title") String title,
                               @RequestParam("author") String author,
                               @RequestParam("genre") String genre,
                               @RequestParam("imagePath") MultipartFile imagePath) {
        khtBookService.insertBook(title, author, genre, imagePath);
    }

    @PutMapping("/books/{id}/update")
    public int updateBooks(@PathVariable("id") int id,
                           @RequestParam("title") String title,
                           @RequestParam("author") String author,
                           @RequestParam("genre") String genre,
                           @RequestParam("imagePath") MultipartFile imagePath) {
        log.info("KHTBook PutMapping : {}, {}, {}, {}, {}", id, title, author, genre, imagePath);
        KHTBook khtBook = khtBookService.findById(id);
        return bookService.updateById(title, author, genre, imagePath, khtBook);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteBook(@PathVariable("id") int id) {
        return bookService.deleteById(id);
    }
}
