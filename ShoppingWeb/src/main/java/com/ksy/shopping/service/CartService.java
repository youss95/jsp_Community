package com.ksy.shopping.service;

import java.util.List;

import com.ksy.shopping.domain.cart.CartDao;
import com.ksy.shopping.domain.cart.dto.CartReqDto;

public class CartService {

	CartDao cartdao;
	public CartService() {
		cartdao = new CartDao();
	}
	
	public int 장바구니(int product_no,int user_no) {
		
		return cartdao.shoppingCart(product_no,user_no);
	}
}
