package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Product;

import java.util.List;

public interface ProductService {
    // 접근제어자 자료형 mapper.xml 에 작성한 id 명칭
    List<Product> findAllProducts();

    // 제품 검색 (상품명 또는 카테고리)
    List<Product> searchProducts(String keyword);

    // 특정 제품 상세 조회 (ID 기반으로 검색)
    Product findProductById(int productId);

    // 제품 저장 -> 자료형 : void, int
    void saveProduct(Product product);
}
