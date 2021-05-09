package com.ksy.usr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksy.model.MemberBean;
import com.ksy.model.MemberDAO;


@WebServlet("/usr/member/list")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	reqPro(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		MemberDAO bdao = new MemberDAO();
		ArrayList<MemberBean> list = bdao.getAllMember();
		
		request.setAttribute("list", list);
		RequestDispatcher dis =request.getRequestDispatcher("/jsp/usr/member/list.jsp");
		dis.forward(request, response);
		
		
		
	}
}
