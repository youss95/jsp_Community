package com.ksy.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksy.blog.domain.user.dto.JoinReqDto;
import com.ksy.blog.domain.user.dto.LoginReqDto;
import com.ksy.blog.service.UserService;


@WebServlet("/user")
public class UserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
//http://localhost:8080/user?cmd=
//member 과련 요청 처리
	//이 정도는 따로 메서드로 만드는 것보다 오브젝트로 만들어서 하는것이 편함
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd= request.getParameter("cmd");
		
		UserService userService = new UserService();
		
		if(cmd.equals("loginForm")) {
			
			response.sendRedirect("user/LoginForm.jsp");
		}else if(cmd.equals("login")) {
			//서비스
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			LoginReqDto dto = new LoginReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			userService.로그인(dto);
			
		} else if(cmd.equals("joinForm.jsp")) {
		response.sendRedirect("user/joinForm.jsp");
	} else if(cmd.equals("join")) {
		//서비스
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		JoinReqDto dto = new JoinReqDto();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setEmai(email);
		dto.setAddress(address);
		userService.회원가입(dto);
	}
	
	}
}
