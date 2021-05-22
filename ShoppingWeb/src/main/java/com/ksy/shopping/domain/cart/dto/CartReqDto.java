package com.ksy.shopping.domain.cart.dto;

import lombok.Data;

@Data
public class CartReqDto {

	private int cart_no;
	private int product_no;
	private String cart_qty;
	
}
