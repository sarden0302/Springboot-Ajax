package com.kht.Ecommerce.mapper;

import com.kht.Ecommerce.dto.Cart;
import com.kht.Ecommerce.vo.CartProductsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    //List<CartProductsVo> getAllCartsProductVo(int cartId);
    List<Cart> getCartByUserId(int userId);
}
