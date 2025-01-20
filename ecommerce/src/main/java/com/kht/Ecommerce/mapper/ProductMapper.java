package com.kht.Ecommerce.mapper;

import com.kht.Ecommerce.dto.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Products> getAllProducts();
}
