package com.ksy.shopping.domain.cart;

import java.sql.Date;

import com.ksy.shopping.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

	private int cart_no;
	private int  user_no;
	private int product_no;
	private String cart_qty; //수량
	
}
