package com.ksy.animal.domain.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ksy.animal.config.Db;

public class ReplyDao {

	PreparedStatement pstmt;
	Connection con;
	ResultSet rs;
	
	public int insertReply(String user_id, int user_no , int blognum,String reply_content) {
		con = Db.getCon();
		String sql = "insert into reply values(reply_seq.nextval,?,?,?,?,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_no);
			pstmt.setInt(2, blognum);
			pstmt.setString(3, user_id);
			pstmt.setString(4, reply_content);
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
