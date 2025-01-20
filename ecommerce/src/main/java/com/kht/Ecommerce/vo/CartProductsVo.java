package com.kht.Ecommerce.vo;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class CartProductsVo {

    private int cartId;
    private String title;
    private int price;
    private int quantity;
}
