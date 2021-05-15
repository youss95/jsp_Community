package com.ksy.blog.service;

import java.util.List;

import com.ksy.blog.domain.board.Board;
import com.ksy.blog.domain.board.BoardDao;
import com.ksy.blog.domain.board.dto.WriteReqDto;

public class BoardService {
	
	private BoardDao boardDao;
	public BoardService() {
		boardDao = new BoardDao();
	}
	
public int 글쓰기(WriteReqDto dto) {
	
	
	int result = boardDao.save(dto);
	return result;
	}

public List<Board> 글목록(int page){
	List<Board> list =  boardDao.showList(page);
	
	return list;
}

public int 글개수() {
	
	return boardDao.getCount();
}

}
