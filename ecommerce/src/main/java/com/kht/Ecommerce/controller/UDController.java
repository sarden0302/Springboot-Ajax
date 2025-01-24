package com.kht.Ecommerce.controller;

import com.kht.Ecommerce.dto.Products;
import com.kht.Ecommerce.service.ProductService;
import com.kht.Ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// View -> html 파일 바라보기
// Rest -> back-end 가 DB 에서 가져온 데이터를 url 주소 값으로 전달만 하는 상태
@RestController
@RequestMapping("/api")
public class UDController {

    @Autowired
    ProductServiceImpl productService;

    // 제품 update
    // html 파일에서 전달받은 업데이트 상탵 내용을 DB 에 수정하기
    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Products products) {
        products.setId(id);
        productService.updateProduct(products);
    }

}
