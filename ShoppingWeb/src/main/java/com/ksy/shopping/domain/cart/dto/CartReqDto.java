package com.ksy.shopping.domain.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CartReqDto {

	private int cart_no;
	private int user_no;
	private int product_no;
	private int cart_qty;
private String product_name;
private String filename;

}
