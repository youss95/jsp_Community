package com.ksy.animal.domain.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.animal.config.Db;
import com.ksy.animal.domain.blog.dto.WriteDto;

public class BlogDao {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	
	public int writeArticle(WriteDto dto) {
		con = Db.getCon();
		
		String sql="insert into blog (bNo,user_no,bTitle,bContent,bfileName,bfileRealName,bHit,bCreateDate) values(blog_seq.nextval,?,?,?,?,?,0,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_no());
			pstmt.setString(2, dto.getBTitle());
			pstmt.setString(3, dto.getBContent());
			pstmt.setString(4, dto.getBfileName());
			pstmt.setString(5, dto.getBfileRealName());
		int result =pstmt.executeUpdate();
		System.out.println(result);
		return result;
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Db.close(con, pstmt);
		}
		return -1;
	}
	
	
	
}
