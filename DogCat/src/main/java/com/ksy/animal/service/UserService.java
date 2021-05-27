package com.ksy.animal.service;

import com.ksy.animal.domain.user.User;
import com.ksy.animal.domain.user.UserDao;
import com.ksy.animal.domain.user.dto.JoinDto;
import com.ksy.animal.domain.user.dto.LoginDto;

public class UserService {

	
	UserDao userDao;
	public UserService() {
		userDao = new UserDao();
	}
	
	public int 회원가입(JoinDto dto) {
		
		return userDao.join(dto);
	}
	
	
	public User 로그인(LoginDto dto) {
		
		return userDao.login(dto);
	}
	
}
