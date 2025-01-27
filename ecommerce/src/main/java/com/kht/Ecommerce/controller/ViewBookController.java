package com.kht.Ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewBookController {
    /*
    View - html 주소
    html 파일을 바라보는 주소와 url 명칭 보통 동일하게 작성
    예외) 수정 / 상세보기 / 검색 일치하지 않을 수 있음

    Api - JSON 데이터 주소
    html 파일명과 api 주소와 다르게 작성
     */
    @GetMapping("/books")
    public String getBooks() {
        return "books";
    }

    @GetMapping("/book")
    public String getBookById(@RequestParam("id") int id) {
        return "book-detail";
    }

    @GetMapping("/book/add")
    public String saveBook() {
        return "newBooks";
    }

    @GetMapping("/books/update")
    public String updateBook(@RequestParam("id") int id) {
        return "book-edit";
    }
}
