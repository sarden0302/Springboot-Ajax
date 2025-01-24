package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();

    void addProduct();

    Products getProductById(int id);

    void updateProduct(Products product);
}
