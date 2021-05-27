package com.ksy.animal.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.animal.config.Db;
import com.ksy.animal.domain.user.dto.JoinDto;
import com.ksy.animal.domain.user.dto.LoginDto;

public class UserDao {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	
	public int join(JoinDto dto) {
		con = Db.getCon();
		 String sql ="insert into semi_user (user_no,user_id,user_password,user_email,user_address,createDate) values(semi_user_seq.nextval,?,?,?,?,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getUser_password());
			pstmt.setString(3, dto.getUser_email());
			pstmt.setString(4, dto.getUser_address());
			int result = pstmt.executeUpdate();
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt);
			
		}
		return -1;
	}
	
	public User login(LoginDto dto) {
		con = Db.getCon();
	    String sql ="select user_no,user_id,user_email,user_address,userRole from semi_user where user_id=? and user_password=?";
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
	
}
