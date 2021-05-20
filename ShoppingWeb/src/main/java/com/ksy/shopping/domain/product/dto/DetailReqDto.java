package com.ksy.shopping.domain.product.dto;

import lombok.Data;

@Data
public class DetailReqDto {

	private int product_no;
	private String product_category;
	private String product_stock;
	private String product_name;
	private String product_color;
	private String product_size;
	private String product_price;
	private String filename;
}
