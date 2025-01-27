package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.KHTBook;
import com.kht.Ecommerce.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ApiBookController {

    @Autowired
    private BookServiceImpl khtBookService;

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
    public KHTBook saveBookImg(@RequestParam("title") String title,
                               @RequestParam("author") String author,
                               @RequestParam("genre") String genre,
                               @RequestParam("file") MultipartFile file) {
        return null;
    }

    @PutMapping("/books/{id}/update")
    public int updateBooks(@PathVariable("id") int id,
                           @RequestBody KHTBook khtBook) {
        khtBook.setId(id);
        return 1;
    }

}
