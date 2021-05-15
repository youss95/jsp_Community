package com.ksy.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ksy.blog.config.DBConnection;
import com.ksy.blog.domain.board.dto.WriteReqDto;
import com.ksy.blog.domain.user.dto.JoinReqDto;

public class BoardDao {

	public int save(WriteReqDto dto) { // 글쓰기\
		
		//로그인한 userId는 boardController에서 들고오기
		
		String sql ="insert into board (id,userId,title,content,createDate) values (board_seq.nextval,?,?,?,sysdate)";
		Connection con = DBConnection.getCon();
		PreparedStatement pstmt=null;
		int result=0;
		try {
		 pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3, dto.getContent());
		 result = pstmt.executeUpdate();
			return result;
		} catch(Exception e) {
			e.printStackTrace();
		} 
return -1;
	}
	
}
