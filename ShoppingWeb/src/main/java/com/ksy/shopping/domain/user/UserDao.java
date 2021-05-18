package com.ksy.shopping.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.shopping.config.Db;
import com.ksy.shopping.domain.user.dto.JoinReqDto;

public class UserDao {
Connection con;
PreparedStatement pstmt;
ResultSet rs;
	//회원가입
	public int join(JoinReqDto dto) {
		 con = Db.getCon();
		 String sql ="insert into shopping_user (user_no,user_id,user_password,user_email,user_address,createDate) values(shopping_user_seq.nextval,?,?,?,?,sysdate)";
		 try {
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, dto.getUser_id());
			 pstmt.setString(2, dto.getUser_password());
			 pstmt.setString(3, dto.getUser_email());
			 pstmt.setString(4, dto.getUser_address());
			 int result = pstmt.executeUpdate();
			 return result;			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 Db.close(con, pstmt);
		 }
		 return -1;
	}
	
	
}
