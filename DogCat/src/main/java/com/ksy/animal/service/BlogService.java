package com.ksy.animal.service;

import java.util.List;

import com.ksy.animal.domain.blog.Blog;
import com.ksy.animal.domain.blog.BlogDao;
import com.ksy.animal.domain.blog.dto.DetailDto;
import com.ksy.animal.domain.blog.dto.ShowDto;
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
	
	public List<ShowDto> 블로그목록보기(){
		return blogDao.showBlog();
	}
	
	
	public Blog 글보기(String title) {
		
		int result = blogDao.조회수(title);
		if(result>0)
		return blogDao.showArticle(title);
		return null;
	}
	
}
