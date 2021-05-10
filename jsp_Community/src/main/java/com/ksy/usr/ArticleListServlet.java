package com.ksy.usr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/usr/article/list")
public class ArticleListServlet extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(request.getParameter("boardId")==null) {
			response.getWriter().append("boardId입력");
			return;
		}
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		
		
		RequestDispatcher dis =request.getRequestDispatcher("/jsp/usr/article/list.jsp");
		dis.forward(request, response);
	}
}