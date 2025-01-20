package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.vo.CartProductsVo;

import java.util.List;

public interface CartService {
    //List<CartProductsVo> getAllCartsProductVo(int cartId);
    List<Cart> getCartByUserId(int userId);
}
