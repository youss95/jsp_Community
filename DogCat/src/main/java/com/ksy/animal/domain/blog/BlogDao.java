package com.ksy.animal.domain.blog;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.animal.config.Db;
import com.ksy.animal.domain.blog.dto.ShowDto;
import com.ksy.animal.domain.blog.dto.WriteDto;

public class BlogDao {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	
	
	//블로그 글쓰기
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
	
	
	//블로그 페이지 내용 정렬 , semi_user, blog 조인
	public List<ShowDto> showBlog(){
		con = Db.getCon();
		List<ShowDto> list = new ArrayList<>();
		String sql = "select b.bTitle,u.user_id,b.bfileName, b.bfileRealName,b.bCreateDate from blog b left outer join semi_user u on b.user_no = u.user_no  order by b.bCreateDate desc";
		try {
			pstmt = con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			String user_id = rs.getString("user_id");
			String bTitle = rs.getString("bTitle");
			String bfileName = rs.getString("bfileName");
			String bfileRealName = rs.getString("bfileRealName");
			Date bCreateDate = rs.getDate("bCreateDate");
			ShowDto dto = new ShowDto(user_id,bTitle,bfileName,bfileRealName,bCreateDate);					
						
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
