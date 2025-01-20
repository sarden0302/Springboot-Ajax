package com.kht.Ecommerce.service;

import com.kht.Ecommerce.vo.CartProductsVo;

import java.util.List;

public interface CartService {
    List<CartProductsVo> getAllCartsProductVo(int cartId);
}
