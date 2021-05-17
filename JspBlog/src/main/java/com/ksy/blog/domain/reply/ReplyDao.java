package com.ksy.blog.domain.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.blog.config.DBConnection;
import com.ksy.blog.domain.reply.dto.SaveReqDto;

public class ReplyDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int save(SaveReqDto dto) {
		Connection con = DBConnection.getCon();
		String sql = "insert into reply (id,userId,boardId,content,createDate) values(reply_seq.nextval,?,?,?,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setInt(2, dto.getBoardId());
			pstmt.setString(3, dto.getContent());
			int result = pstmt.executeUpdate();
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt);
		}
		return -1;
	}
	
}
