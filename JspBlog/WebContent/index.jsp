<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- sendRedirect는 필터로 인하여 jsp 접근이 불가 따라서 RequestDispatcher 사용 -->
<%
RequestDispatcher dis = request.getRequestDispatcher("board?cmd=list&page=1");  ///JspBLog필요없음 내가 그 안에 있으니까
dis.forward(request, response); //톰캣이 생성한 request, response를 재사용
%>