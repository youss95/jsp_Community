package com.ksy.blog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.blog.domain.user.User;
import com.ksy.blog.domain.user.dto.JoinReqDto;
import com.ksy.blog.domain.user.dto.LoginReqDto;
import com.ksy.blog.service.UserService;
import com.ksy.blog.util.Script;


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
		
		if(cmd.equals("LoginForm")) {
			//response.sendRedirect("/JspBlog/user/LoginForm.jsp"); 필터를 탄다
			RequestDispatcher dis = request.getRequestDispatcher("user/LoginForm.jsp");
			dis.forward(request, response); //톰캣이 생성한 request, response를 재사용
			
		}else if(cmd.equals("login")) {
			//서비스
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			LoginReqDto dto = new LoginReqDto();
			dto.setUsername(username);
			dto.setPassword(password);
			//System.out.println("username: "+username);
		User userEntity =	userService.로그인(dto);   //디비로부터 받은것은 Entity
		//System.out.println(userEntity);
			//세션객체에 담기
		if(userEntity!=null) {
				HttpSession session =request.getSession();
				session.setAttribute("sessionUser", userEntity);
			response.sendRedirect("index.jsp");
			} else {
				Script.back(response, "로그인에 실패하였습니다.");
			}
		} else if(cmd.equals("JoinForm")) {
		//response.sendRedirect("user/JoinForm.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("user/JoinForm.jsp");
			dis.forward(request, response); //톰캣이 생성한 request, response를 재사용
	} else if(cmd.equals("join")) {
		//서비스
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		JoinReqDto dto = new JoinReqDto();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setEmail(email);
		dto.setAddress(address);
	
		System.out.println(dto);
		int result = userService.회원가입(dto);
		System.out.println("con"+result);
		if(result == 1) {
			response.sendRedirect("index.jsp");
		} else {
			Script.back(response, "회원가입실패");
		}
	} else if(cmd.equals("usernameCheck")) {
		//dataType: text로 넘어 왔기때문에 buffer로 읽는다
		BufferedReader br = request.getReader();  //넘어온 text읽기
		String username = br.readLine(); 
		System.out.println(username);
		int result = userService.유저네임중복체크(username);  //db에 던지기
	PrintWriter out = response.getWriter();
		if(result == 1) {
			out.print("ok");
		} else {
			out.print("fail");
		}
		out.flush();
	} else if(cmd.equals("Logout")) {
		//session 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	} 
			
	
	}
}
