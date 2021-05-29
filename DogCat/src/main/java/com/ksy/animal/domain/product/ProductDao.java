package com.ksy.animal.domain.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.animal.config.Db;
import com.ksy.animal.domain.product.dto.UploadDto;

public class ProductDao {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	
	public List<Product> showProductList(){
		con = Db.getCon();
		List<Product> list = new ArrayList<>();
		String sql = "select * from semi_product order by pNo desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product product = Product.builder()
						.productnumber(rs.getInt("pNo"))
						.pCategory(rs.getString("pCategory"))
						.pStock(rs.getInt("pStock"))
						.name(rs.getString("pName"))
						.pColor(rs.getString("pColor"))
						.pSize(rs.getString("pSize"))
						.pDetail(rs.getString("pDetail"))
						.price(rs.getInt("pPrice"))
						.pCreateDate(rs.getDate("pCreateDate"))
						.pHit(rs.getInt("pHit"))
						.pfileName(rs.getString("pfileName"))
						.fileRealName(rs.getString("pfileRealName"))
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
	
	//상품등록
	public int uploadProduct(UploadDto dto) {
		con = Db.getCon();
		String sql = "insert into semi_product values(semi_product_seq.nextval,?,?,?,?,?,?,?,sysdate,0,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPCategory());
			pstmt.setInt(2, dto.getPStock());
			pstmt.setString(3, dto.getPName());
			pstmt.setString(4, dto.getPColor());
			pstmt.setString(5, dto.getPSize());
			pstmt.setString(6, dto.getPDetail());
			pstmt.setInt(7, dto.getPPrice());
			pstmt.setString(8, dto.getPfileName());
			pstmt.setString(9, dto.getFielRealName());
			
			int result = pstmt.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt);
		}
		return -1;
	}
	
	
}
