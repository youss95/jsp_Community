package com.ksy.shopping.domain.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.shopping.config.Db;
import com.ksy.shopping.domain.cart.dto.CartReqDto;

public class CartDao {
Connection con;
PreparedStatement pstmt;
ResultSet rs;

	
	//장바구니
	public int shoppingCart(int product_no,int user_no){

		con = Db.getCon();
		String sql ="insert into shopping_cart (cart_no,product_no,user_no) values(shopping_cart_seq.nextval, ?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			pstmt.setInt(2, user_no);
			int result = pstmt.executeUpdate();
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, rs, pstmt);
		}
		return -1;
	}
	
}
