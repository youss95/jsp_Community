package com.ksy.shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksy.shopping.domain.user.User;
import com.ksy.shopping.domain.user.dto.JoinReqDto;
import com.ksy.shopping.domain.user.dto.LoginReqDto;
import com.ksy.shopping.service.UserService;
import com.ksy.shopping.util.Script;

//http://localhost:8080/ShoppingWeb/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}
	UserService userService = new UserService();
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("LoginForm")) {
			response.sendRedirect("user/LoginForm.jsp");
		} else if(cmd.equals("login")) {
			LoginReqDto dto = new LoginReqDto();
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			dto.setUser_id(user_id);
			dto.setUser_password(user_password);
			User user = userService.로그인(dto);
		} else if(cmd.equals("JoinForm")) {
			response.sendRedirect("user/JoinForm.jsp");
		}else if(cmd.equals("join")) {
			
			JoinReqDto dto = new JoinReqDto();
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			String user_email = request.getParameter("user_email");
			String user_address = request.getParameter("user_address");
			dto.setUser_id(user_id);
			dto.setUser_password(user_password);
			dto.setUser_email(user_email);
			dto.setUser_address(user_address);
			int result = userService.회원가입(dto);
			if(result == 1) {
				Script.writeSuccess(response, "회원가입에 성공하셨습니다.");
			} else {
				Script.back(response, "회원가입 실패");
			}
		}


	}

}