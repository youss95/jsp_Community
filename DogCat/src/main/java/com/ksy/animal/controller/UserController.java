package com.ksy.animal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.animal.domain.user.User;
import com.ksy.animal.domain.user.dto.JoinDto;
import com.ksy.animal.domain.user.dto.LoginDto;
import com.ksy.animal.service.UserService;
import com.ksy.animal.util.Script;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	reqpro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqpro(request,response);
	}
	UserService userService = new UserService();
	protected void reqpro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("JoinForm")) {
			response.sendRedirect("pet/user/JoinForm.jsp");
		} else if(cmd.equals("join")) {
			JoinDto dto = new JoinDto();
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			String user_email = request.getParameter("user_email");
			String address1 = request.getParameter("user_address");
			String address2 = request.getParameter("user_addressDetail");
			String user_address = address1+" "+address2;
			
			dto.setUser_id(user_id);
			dto.setUser_password(user_password);
			dto.setUser_email(user_email);
			dto.setUser_address(user_address);
			int result = userService.회원가입(dto);
			if(result==1) {
				Script.writeSuccess(response, "회원가입에 성공하였습니다.");
			}else {
				Script.back(response, "회원가입 실패");
			}
		}else if(cmd.equals("login")) {
			LoginDto dto = new LoginDto();
			String user_id= request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			
			dto.setUser_id(user_id);
			dto.setUser_password(user_password);
			
			User user = userService.로그인(dto);
			System.out.println(user);
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionUser", user);
				Script.writeSuccess(response, "로그인 성공");
			}else {
				Script.back(response, "로그인 실패");
			}
		}else if(cmd.equals("LoginForm")) {
			response.sendRedirect("pet/user/LoginForm.jsp");
		}else if(cmd.equals("logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
			Script.writeSuccess(response, "로그아웃 되었습니다.");
		}
		
	}
}
