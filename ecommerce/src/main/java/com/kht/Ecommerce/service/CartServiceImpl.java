package com.kht.Ecommerce.service;

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
    public List<CartProductsVo> getAllCartsProductVo(int cartId) {
        return cartMapper.getAllCartsProductVo(cartId);
    }
}
