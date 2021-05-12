package com.ksy.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.blog.config.DBConnection;
import com.ksy.blog.domain.user.dto.JoinReqDto;
import com.ksy.blog.domain.user.dto.LoginReqDto;

public class UserDao {

	public int findByUsername(String username) { // 중복체크
		String sql ="select username from member where username=? ";
		Connection con = DBConnection.getCon();
		PreparedStatement pstmt=null;
	ResultSet rs = null;
		try {
		 pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		 rs = pstmt.executeQuery();
		
		 if(rs.next()) {
			 return 1;      //존재
		 }
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt,rs);
		}
return -1;
	}
	
	
	public int save(JoinReqDto dto) { // 회원가입
		String sql ="insert into member (id,username,password,email,address,userRole,createDate) values(member_seq.nextval,?,?,?,?,'USER',sysdate)";
		Connection con = DBConnection.getCon();
		PreparedStatement pstmt=null;
		int result=0;
		try {
		 pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getUsername());
		pstmt.setString(2, dto.getPassword());
		pstmt.setString(3, dto.getEmail());
		pstmt.setString(4, dto.getAddress());
		 result = pstmt.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		} 
return -1;
	}

	public void update() { // 회원수정

	}

	public void usernameCheck() { // 아이디 중복 체크

	}

	public void findById() { // 회원정보 보기

	}
}
