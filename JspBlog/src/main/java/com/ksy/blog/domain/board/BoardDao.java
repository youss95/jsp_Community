package com.ksy.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksy.blog.config.DBConnection;
import com.ksy.blog.domain.board.dto.DetailRespDto;
import com.ksy.blog.domain.board.dto.WriteReqDto;
import com.ksy.blog.domain.user.dto.JoinReqDto;

public class BoardDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int save(WriteReqDto dto) { // 글쓰기\
		
		//로그인한 userId는 boardController에서 들고오기
		
		String sql ="insert into board (id,userId,title,content,createDate) values (board_seq.nextval,?,?,?,sysdate)";
		Connection con = DBConnection.getCon();
	
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
	
	//게시글 가져오기
	public List<Board> showList(int page){
		Connection con = DBConnection.getCon();
		List<Board> list = new ArrayList<>();
		String sql ="select x.* from(select rownum as rnum, A.* from (select * from board order by id desc) A  where rownum <=?) x where x.rnum >=?";  //최신순으로
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, page*4);
			pstmt.setInt(2, (page-1)*4+1);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				/*
				 * 생성자 인자가 많거나 매개변수가 많다면  빌더 패턴 적용
				board.setId(rs.getInt("id"));
				board.setUserId(rs.getInt("userId"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setReadCount(rs.getInt("readCount"));
				board.setCreateDate(rs.getDate("createDate"));
				*/
				Board board = Board.builder()
						.id(rs.getInt("id"))
						.userId(rs.getInt("userId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getDate("createDate"))
						.build();
				list.add(board);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		
		return null;
		
	}
	
	//상세글 보기 - 조인된 dto에 담기
	public DetailRespDto getDetail(int id){
		Connection con = DBConnection.getCon();
		
		String sql = "select b.id,b.title,b.readCount,b.content, m.username \r\n"
				+ "from board b inner join member m \r\n"
				+ "on b.userId = m.id\r\n"
				+ "where b.id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				DetailRespDto dto = new DetailRespDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setContent(rs.getString("content"));
				dto.setUsername(rs.getString("username"));
				return dto;	
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return null;
	}
	
	
	
	
	
	
	public int getCount() {
		Connection con = DBConnection.getCon();
		String sql = "select count(*) from board";
		
		try {
		pstmt=con.prepareStatement(sql);
		rs = pstmt.executeQuery();	
		if(rs.next()) {
			return rs.getInt(1);
		}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt);
		}
		return -1;
	}
	
}



