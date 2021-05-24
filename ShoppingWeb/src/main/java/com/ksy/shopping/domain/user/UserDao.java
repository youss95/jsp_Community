package com.ksy.shopping.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.shopping.config.Db;
import com.ksy.shopping.domain.user.dto.JoinReqDto;
import com.ksy.shopping.domain.user.dto.LoginReqDto;

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
	
	//로그인
	public User login(LoginReqDto dto) {
		con=Db.getCon();
		String sql ="select user_no,user_id,user_email,user_address,userRole from shopping_user where user_id=? and user_password=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_password());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				User user = User.builder()
						.user_no(rs.getInt("user_no"))
						.user_id(rs.getString("user_id"))
						.user_email(rs.getString("user_email"))
						.user_address(rs.getString("user_address"))
						.userRole(rs.getString("userRole"))
						.build();
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, rs, pstmt);
		}
		return null;
	}
	//아이디 중복체크
	public int findByUsername(String user_id) {
		con=Db.getCon();
		String sql = "select user_id from shopping_user where user_id = ? ";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, rs, pstmt);
		}
		return -1;
	}
	
}
