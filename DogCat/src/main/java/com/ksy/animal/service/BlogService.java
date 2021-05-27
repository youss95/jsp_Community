package com.ksy.animal.service;

import com.ksy.animal.domain.blog.BlogDao;
import com.ksy.animal.domain.blog.dto.WriteDto;
import com.ksy.animal.domain.user.User;
import com.ksy.animal.domain.user.UserDao;
import com.ksy.animal.domain.user.dto.JoinDto;
import com.ksy.animal.domain.user.dto.LoginDto;

public class BlogService {

	
	BlogDao blogDao;
	public BlogService() {
		blogDao = new BlogDao();
	}
	
	public int 글쓰기(WriteDto dto) {
		
		return blogDao.writeArticle(dto);
	}
	
}