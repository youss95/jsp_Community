package com.ksy.shopping.service;

import com.ksy.shopping.domain.user.User;
import com.ksy.shopping.domain.user.UserDao;
import com.ksy.shopping.domain.user.dto.JoinReqDto;
import com.ksy.shopping.domain.user.dto.LoginReqDto;
import com.ksy.shopping.domain.user.dto.UpdateReqDto;

public class UserService {

	/*
	 * 회원가입, 로그인, 로그아웃, 탈퇴, 아이디중복체크, 회원수정
	 * 로그아웃은 컨트롤러에서
	 * 서비스는 request 없이 작업
	 */
	UserDao userDao;
	public UserService() {
		userDao = new UserDao();
	}
	
	
	public int 회원가입(JoinReqDto dto) {
		
		return userDao.join(dto);
	}
	
	public User 로그인(LoginReqDto dto) {
		
		return null;
	}
	
	public int 아이디중복체크(String username) {
		
		return -1;
	}
	
	
	public int 회원수정(UpdateReqDto dto) {
		
		return -1;
	}

	
}
