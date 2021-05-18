package com.ksy.shopping.domain.purchase;

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
public class Purchase {

	private int purchase_no;
	private int user_no;
	private int product_no;
	private int purchase_qty;
	private Date purchase_date;
	private String purchase_status;
	
}
