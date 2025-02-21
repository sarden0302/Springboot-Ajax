package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.Product;
import kh.edu.react.provider.service.ProductService;
import kh.edu.react.provider.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* URL vs API vs EndPoint
    URL      : 웹에서 특정 리소스(페이지, 이미지, API 등)에 접근하기 위한 주소
                ex) https  ://   www.kht.com  /api/users/123
                  프로토콜  구분자     도메인      경로(path)
    API      : 프로그램 간 데이터와 기능을 주고 받을 수 있도록 만든 인터페이스
                API 는 여러 개의 EndPoint(접속 지점) 포함
                [방식] REST API (get, put, post, patch, delete)
    EndPoint : API 에서 특정 작업을 수행하는 URL
                ex) https  ://   www.kht.com  /api/users/123
                -> GET    /api/users/123
                   POST   /api/users/123
                   PUT    /api/users/123
                   DELETE /api/users/123

   [음식점]
   URL -> 주소
    - 인터넷상  : https://www.kht.com
    - 실제 주소 : 서울시 강남구 oo동 123번지
   API -> 서비스(기능)
    ex) 물 리필, 음식
   EndPoint -> 특정 기능을 수행하는 세부 서비스 (GET, POST, PUT, DELETE)
    ex) 메뉴판 : POST /api/orders || GET /api/orders || PUT /api/orders || DELETE /api/orders
*/
// 명칭 : api endpoint
@Slf4j
@RestController
@RequestMapping("/api/products") // api end point
public class ProductAPIController {

    @Autowired
    private ProductServiceImpl productService;

    // 모든 제품 조회
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    // 제품 검색
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

    // 제품 상세 조회
    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable int productId) {
        return productService.findProductById(productId);
    }

    // 제품 저장
    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        // Product product = new Product(productName, productDescription, productPrice, productCategory, productStock, productImageUrl);
        log.info("Saving product {}", product);
        productService.saveProduct(product);
    }
}
