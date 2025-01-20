package com.kht.Ecommerce.service;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.mapper.CartMapper;
import com.kht.Ecommerce.vo.CartProductsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> getCartByUserId(int userId) {
        return cartMapper.getCartByUserId(userId);
    }

    /*
    @Override
    public List<CartProductsVo> getAllCartsProductVo(int cartId) {
        return cartMapper.getAllCartsProductVo(cartId);
    }*/
}
