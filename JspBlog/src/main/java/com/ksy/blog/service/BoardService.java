package com.ksy.blog.service;

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
}
