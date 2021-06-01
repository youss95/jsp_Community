package com.ksy.animal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.animal.domain.user.User;
import com.ksy.animal.service.ReplyService;
import com.ksy.animal.util.Script;


@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}
	
	ReplyService replyService = new ReplyService();
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cmd = request.getParameter("cmd");
		if(cmd.equals("plusReply")) {
			User principal = (User) session.getAttribute("sessionUser");
			//로그인 되어있으면
			if(principal != null) {
			String user_id=request.getParameter("user_id");
			int user_no = Integer.parseInt(request.getParameter("user_no"));
			int blognum = Integer.parseInt(request.getParameter("blognum"));
			String reply_content = request.getParameter("content");
			System.out.println("리플"+reply_content);
			
			int result = replyService.댓글달기(user_id,user_no,blognum,reply_content);
			if(result>0) {
			Script.ReplyWriteSuccess(response, "댓글작성 성공");
				}
			//로그인 안되 있으면 로그인창
			}else {
				Script.IfNotLogin(response, "로그인이 필요합니다.");
			}
		}
		
		}
	}


