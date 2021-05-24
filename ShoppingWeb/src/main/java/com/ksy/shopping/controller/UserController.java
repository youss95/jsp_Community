package com.ksy.shopping.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.shopping.domain.user.User;
import com.ksy.shopping.domain.user.dto.JoinReqDto;
import com.ksy.shopping.domain.user.dto.LoginReqDto;
import com.ksy.shopping.service.ProductService;
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
		//로그인
		if(cmd.equals("LoginForm")) {
			response.sendRedirect("user/LoginForm.jsp");
		} else if(cmd.equals("login")) {
			LoginReqDto dto = new LoginReqDto();
			String user_id = request.getParameter("user_id");
			String user_password = request.getParameter("user_password");
			dto.setUser_id(user_id);
			dto.setUser_password(user_password);
			User user = userService.로그인(dto);
			//로그인 되었다면 user가 null이 아니다.
			if(user!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("sessionUser", user);
				Script.writeSuccess(response, "로그인에 성공하였습니다.");
			} else {
				Script.back(response, "로그인에 실패하였습니다.");
			}
		} else if(cmd.equals("JoinForm")) {
			response.sendRedirect("user/JoinForm.jsp");
		}else if(cmd.equals("join")) {
			
			JoinReqDto dto = new JoinReqDto();
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
			if(result == 1) {
				Script.writeSuccess(response, "회원가입에 성공하셨습니다.");
			} else {
				Script.back(response, "회원가입 실패");
			}
		} else if(cmd.equals("logout")) {
			//로그아웃은 세션 무효화
			HttpSession session = request.getSession();
			session.invalidate(); //세션 무효화
			Script.writeSuccess(response, "로그아웃 되었습니다.");
		} else if(cmd.equals("usernameCheck")) {
			
			BufferedReader br = request.getReader();  //넘어온 text읽기
			String user_id = br.readLine(); 
			System.out.println(user_id);
			int result = userService.유저네임중복체크(user_id);  //db에 던지기
			System.out.println(result);
		    PrintWriter out = response.getWriter();
			if(result == 1) {
				out.print("ok");
			} else {
				out.print("fail");
			}
			out.flush();
		}
	


	}

}