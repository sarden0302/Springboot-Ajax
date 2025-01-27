package com.kht.Ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping(value = "/books", params = {})
    public String getBooks() {
        return "books";
    }

    /*
        Mapping = 특정 주소 값으로 기능이나 전달하고자 하는 행위를 감싸서 한 번에 전달
        GET = DB 에서 가져온 값을 전달할 것인가
        POST = 저장할 것인가
        PUT = 수정할 것인가
        DELETE = 삭제할 것인가

        특정 행위를 주고 받고 전달하는 위치 = api = url 주소값

        @   Mapping(value = "url 명칭 / api 명칭", 주소 값 뒤나 중간에 사용할 파라미터가 존재하는가?
        params 은 {} 가 default 값으로 지정되어 있다.
     */
    @GetMapping(value = "/books", params = "id")    // 1. /books/detail?id=아이디값     // 2. params = "id" 추가
    public String getBookById(@RequestParam("id") int id) {
        return "book-detail";
    }

    @GetMapping("/book/add")
    public String saveBook() {
        return "newBooks";
    }

    @GetMapping("/books/update")
    public String updateBook(@RequestParam("id") int id, Model model) {
        // model.addAttribute("book", id);
        return "book-edit";
    }
}