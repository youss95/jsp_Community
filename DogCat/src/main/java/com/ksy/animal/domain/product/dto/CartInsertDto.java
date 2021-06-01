package com.ksy.animal.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartInsertDto {

	private int cart_no;
	private int user_no;
	private int pNo;
	private int cart_qty;
	
}
