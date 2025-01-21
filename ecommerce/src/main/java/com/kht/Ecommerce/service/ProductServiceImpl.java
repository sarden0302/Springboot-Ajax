package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.Products;
import com.kht.Ecommerce.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Products> getAllProducts() {
        return productMapper.getAllProducts();
    }

    @Override
    public void addProduct() {
        productMapper.addProduct();
    }

    @Override
    public Products getProductById(int id) {
        return productMapper.getProductById(id);
    }
}
