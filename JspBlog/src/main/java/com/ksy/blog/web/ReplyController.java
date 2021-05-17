package com.ksy.blog.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksy.blog.domain.reply.dto.SaveReqDto;
import com.ksy.blog.service.BoardService;
import com.ksy.blog.service.ReplyService;
import com.ksy.blog.util.Script;


@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		ReplyService replyService = new ReplyService();
		HttpSession session = request.getSession();
		if(cmd.equals("save")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			int boardId = Integer.parseInt(request.getParameter("boardId"));
			String content = request.getParameter("content");
			
			SaveReqDto dto  = new SaveReqDto();
			dto.setUserId(userId);
			dto.setBoardId(boardId);
			dto.setContent(content);
			
			System.out.println("댓글 dto"+dto);
			int result = replyService.댓글쓰기(dto);
			request.setAttribute("dto", dto);
			if(result == 1) {
				RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp"); //request에 데이터를 안담고감
			dis.forward(request, response);
				
				
			} else {
				Script.back(response, "댓글 쓰기 실패");
			}
		}
		
		
	}

	
}
