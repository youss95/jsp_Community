package com.ksy.shopping.domain.product;

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
public class Product {

	private int product_no;
	private String product_category;
	private int product_stock;
	private String roduct_name;
	private String roduct_color;
	private String product_size;
	private int product_price;
	private Date createDate;
	
}
