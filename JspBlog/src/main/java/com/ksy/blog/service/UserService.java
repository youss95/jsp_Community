package com.ksy.blog.service;

import com.ksy.blog.domain.user.User;
import com.ksy.blog.domain.user.UserDao;
import com.ksy.blog.domain.user.dto.JoinReqDto;
import com.ksy.blog.domain.user.dto.LoginReqDto;
import com.ksy.blog.domain.user.dto.UpdateReqDto;

public class UserService {
	
	//모든 메소들에 userDao를 만드는 대신
	private UserDao userDao;
	public UserService( ) {
		userDao = new UserDao();
	}
	
	
//회원가입 수정 로그인 로그아웃 아이디 중복체크 
	//null값 체크 필요해서 dto 로 받는다
	//joinform -> usercontroller -> userservice -> userdao ->usercontroller
	public int 회원가입(JoinReqDto dto) {
	
	int result =  userDao.save(dto);
		System.out.println(result);
		return result;
		
	}
	//select * from user where username=? and password=?
	public User 로그인(LoginReqDto dto) {
		
		return null;
	}
	
	public int 회원수정(UpdateReqDto dto) {
		
		return -1;
	}
	
	//컨트롤러에서 끝낸다. req를 끌고오면 안됨
//	public void 로그아웃() {	
//	}
	
	public int 유저네임중복체크(String username) {
		int result = userDao.findByUsername(username);
		
		return result;
	}
	
}
