package com.ksy.blog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ksy.blog.domain.board.Board;
import com.ksy.blog.domain.board.dto.CommonRespDto;
import com.ksy.blog.domain.board.dto.DeleteReqDto;
import com.ksy.blog.domain.board.dto.DeleteRespDto;
import com.ksy.blog.domain.board.dto.DetailRespDto;
import com.ksy.blog.domain.board.dto.UpdateReqDto;
import com.ksy.blog.domain.board.dto.WriteReqDto;
import com.ksy.blog.domain.reply.dto.SaveReqDto;
import com.ksy.blog.domain.user.User;
import com.ksy.blog.service.BoardService;
import com.ksy.blog.service.ReplyService;
import com.ksy.blog.util.Script;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd= request.getParameter("cmd");
		BoardService boardService = new BoardService();    //boardService 생성자를 호출함으로서 dao 새로 생성 안해도됨
		HttpSession session = request.getSession();
		 if(cmd.equals("WriteForm")) {
			 //아무나 글쓰는 것이 아닌 로그인 한 사람만 글 쓸수 있어야 한다. 인증이 필요
			 //직접 세션 확인 필요
			//하지만 만약 조건문을 통한 접근이 아닌 강제로 url을 통해 가는 상황 이라면?
			User principal = (User) session.getAttribute("sessionUser");   //principal이 있다면 로그인 한 것
			if(principal != null) {
				//response.sendRedirect("board/WriteForm.jsp"); 
				//로그인 되어있다면
				RequestDispatcher dis = request.getRequestDispatcher("board/WriteForm.jsp");
				dis.forward(request, response); //톰캣이 생성한 request, response를 재사용
			} else {
				//response.sendRedirect("/user/LoginForm.jsp");     
				//로그인 되어있지 않다면
				RequestDispatcher dis = request.getRequestDispatcher("user/LoginForm.jsp");
				dis.forward(request, response); //톰캣이 생성한 request, response를 재사용
			}
			//dto 만들어서 파라미터로 던져주는 습관 필요
    	} else if(cmd.equals("save")) {
    		//User principal = (User)session.getAttribute("sessionUser");
    		int userId = Integer.parseInt(request.getParameter("userId"));
    		System.out.println("유저아이디는:"+userId);
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		//int userId = principal.getId(); // 글쓰기에 파라미터로 던져줘도 되지만 애초에 글쓰기 폼에서 히든으로 유저에게 받을수도 있다.
    		//히든값을 너어주면 내 페이지로 부트 들어왔는지 강제로 들어왔는지 체크가 가능 -> 더 안전, 심플
    		WriteReqDto dto = new WriteReqDto();
    		dto.setUserId(userId);
    		dto.setContent(content);
    		dto.setTitle(title);
    		int result = boardService.글쓰기(dto);
    		if(result==1) {
    		
    			Script.writeSuccess(response, "글쓰기 성공");  //글쓰기 성공 alert띄우고 index.jsp로 가기
    		} else {
    			Script.back(response, "글쓰기 실패");
    		}
    		
    		System.out.println(content);
    	} else if(cmd.equals("list")) {
    		int page = Integer.parseInt(request.getParameter("page"));
    	List<Board> list  =	boardService.글목록(page);
    	request.setAttribute("list", list);  //sendRedirect 쓰면 request 사라짐
    	
    	//계산(전체 데이터수랑 한페이지몇개 - 총 몇페이지 나와야 되는지 계산) 3p 라면 2p가 맥스
    	//page == 2되는 순간 isEnd = true request.setAttribute("isEnd",true);
    	
    	int boardCount = boardService.글개수();
    	int lastPage =(int) Math.ceil( boardCount/4.0); //마지막 페이지
    	double currentPercent =(double) (page-1)/(lastPage-1)*100; //현재 페이지의 % 정도
    	System.out.println(boardCount);
    	
    	
 System.out.println(lastPage);
 request.setAttribute("currentPercent", currentPercent);
    	request.setAttribute("lastPage", lastPage);
    	RequestDispatcher dis = request.getRequestDispatcher("board/list.jsp");
    	dis.forward(request, response);
    	} else if(cmd.equals("detail")) {
    		int id = Integer.parseInt(request.getParameter("id"));
        
        	DetailRespDto detailList =  boardService.상세보기(id);  //board + user
        	
        	if(detailList == null) {
        		Script.back(response, "상세보기 실패");
        	} else {
        	request.setAttribute("detailList", detailList);
        	System.out.println(detailList);
        	RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
        	dis.forward(request, response);
    	   }
    	}else if(cmd.equals("delete")) {
    		//json데이터를 읽어와야 한다.
    		
    		//data를 읽기위한 dto 만들고 gson으로 파싱
    		//json을 자바 오브젝트로 파싱
    		int id = Integer.parseInt(request.getParameter("id"));
    	
    		//디비에서 글 삭제
    		int result = boardService.글삭제(id);
    		//응답할 json 데이터 생성
    		
    	CommonRespDto<String> commonRespDto = new CommonRespDto<String>();
    	
    			commonRespDto.setStatusCode(result);
    			commonRespDto.setData("성공");
    			Gson gson = new Gson();
    			String respData = gson.toJson(commonRespDto);
    		                                 
    	
    		PrintWriter out = response.getWriter();
    		out.print(respData);
    		out.flush();
    		
    	
    	} else if(cmd.equals("updateForm")) {
    		//상세보기 데이터를 가져가야 한다.
    		//id도 받아와야 한다.
    		int id = Integer.parseInt(request.getParameter("id"));
    		DetailRespDto updateList=boardService.상세보기(id);
    		
    		request.setAttribute("updateList", updateList);
    		RequestDispatcher dis = request.getRequestDispatcher("board/updateForm.jsp");
    		dis.forward(request, response);
    		
    	}else if(cmd.equals("update")) {
    		int id = Integer.parseInt(request.getParameter("id"));
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		
    		UpdateReqDto dto = new UpdateReqDto();
    		dto.setId(id);
    		dto.setTitle(title);
    		dto.setContent(content);
    		
//    		WriteReqDto dto = new WriteReqDto();
//    		dto.setUserId(userId);
//    		dto.setTitle(title);
//    		dto.setContent(content);
    		
    		int result =  boardService.글수정(dto);
    		if(result == 1) {
    			//어떻게 하면 상세보기 코드를 다시 타게할까?
    			response.sendRedirect("/JspBlog/board?cmd=detail&id="+id);
    		} else {
    			Script.back(response, "글 수정에 실패하였습니다.");
    		}
    	}
	}	
}
