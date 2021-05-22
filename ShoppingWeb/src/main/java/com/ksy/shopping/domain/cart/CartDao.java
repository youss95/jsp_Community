package com.ksy.shopping.domain.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.shopping.config.Db;
import com.ksy.shopping.domain.cart.dto.CartReqDto;
import com.ksy.shopping.domain.product.Product;

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
	
	
	
	//장바구니 목록 user_no가 같아야 함
	
	public List<CartReqDto> showCart( int user_no){
		
			con = Db.getCon();
			List<CartReqDto> list = new ArrayList<>();
			String sql = "select c.cart_no,c.user_no,c.product_no,c.cart_qty,p.product_name,p.filename from shopping_cart c left outer join shopping_product p on p.product_no = c.product_no  where c.user_no=? order by product_createDate desc";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, user_no);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
					CartReqDto dto = CartReqDto.builder()
							.cart_no(rs.getInt("cart_no"))
							.product_no(rs.getInt("product_no"))
							.user_no(rs.getInt("user_no"))
							.cart_no(rs.getInt("cart_no"))
							.product_name(rs.getString("product_name"))
							.filename(rs.getString("filename"))
					.build();
					
					
//					Product product = Product.builder()
//							.product_no(rs.getInt("product_no"))
//							.product_category(rs.getString("product_category"))
//							.product_stock(rs.getString("product_stock"))
//							.product_name(rs.getString("product_name"))
//							.product_color(rs.getString("product_color"))
//							.product_size(rs.getString("product_size"))
//							.product_price(rs.getString("product_price"))
//							.product_createDate(rs.getDate("product_createDate"))
//							.filename(rs.getString("filename"))
//							.fileRealName(rs.getString("fileRealName"))
//							.build();
										list.add(dto);
				}
				return list;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				Db.close(con, rs, pstmt);
			}
			return null;
		}
	
}
