package com.ksy.shopping.domain.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.shopping.config.Db;
import com.ksy.shopping.domain.product.dto.DetailReqDto;
import com.ksy.shopping.domain.product.dto.UploadReqDto;

public class ProductDao {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//업로드
	public int upload(UploadReqDto dto) {
		con = Db.getCon();
		String sql = "insert into shopping_product values(shopping_product_seq.nextval,?,?,?,?,?,?,SYSDATE,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getProduct_category());
			pstmt.setString(2, dto.getProduct_stock());
			pstmt.setString(3, dto.getProduct_name());
			pstmt.setString(4, dto.getProduct_color());
			pstmt.setString(5, dto.getProduct_size());
			pstmt.setString(6, dto.getProduct_price());
			pstmt.setString(7, dto.getFilename());
			pstmt.setString(8, dto.getFielRealName());
			
			int result = pstmt.executeUpdate();
			System.out.println("result"+result);
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt);
		}
		return -1;
	}
	
	//상품목록 보기
	public List<Product> showList(){
		con = Db.getCon();
		List<Product> list = new ArrayList<>();
		String sql = "select * from shopping_product order by product_no desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = Product.builder()
						.product_no(rs.getInt("product_no"))
						.product_category(rs.getString("product_category"))
						.product_stock(rs.getString("product_stock"))
						.product_name(rs.getString("product_name"))
						.product_color(rs.getString("product_color"))
						.product_size(rs.getString("product_size"))
						.product_price(rs.getString("product_price"))
						.product_createDate(rs.getDate("product_createDate"))
						.filename(rs.getString("filename"))
						.fileRealName(rs.getString("fileRealName"))
						.build();
									list.add(product);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, rs, pstmt);
		}
		return null;
	}
	//상세보기
	public DetailReqDto getDetail(int product_no) {
		con = Db.getCon();
		String sql ="select product_no,product_category,product_stock,product_name,product_color,product_size,product_price,filename  from shopping_product where product_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				DetailReqDto dto = new DetailReqDto();
				dto.setProduct_no(rs.getInt("product_no"));
				dto.setProduct_category(rs.getString("product_category"));
				dto.setProduct_stock(rs.getString("product_stock"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_color(rs.getString("product_color"));
				dto.setProduct_size(rs.getString("product_size"));
				dto.setProduct_price(rs.getString("product_price"));
				dto.setFilename(rs.getString("filename"));
				return dto;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, rs, pstmt);
		}
		return null;
	}
	
}
