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
	private String product_stock;
	private String product_name;
	private String product_color;
	private String product_size;
	private String product_price;
	private Date  product_createDate;
	private String filename;
	private String fileRealName;
	
}
