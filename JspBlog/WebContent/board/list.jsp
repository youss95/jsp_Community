
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../layout/header.jsp" %>

<div class="container">

	<div class="m-2">
		<form class="form-inline d-flex justify-content-end" action="/blog/board">
			<input type="hidden" name="cmd" value="search" />
			<input type="hidden" name="page" value="0" />
			
			<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="Search">			
			<button class="btn btn-primary m-1">검색</button>
		
		</form>
	</div>

	<div class="progress col-md-12 m-2">
	
		<div class="progress-bar" style="width: ${currentPercent}%"></div>
	</div>
	
<c:forEach var="board" items="${list }">
		<div class="card col-md-12 m-2">
			<div class="card-body">
				<h4 class="card-title">${board.title }</h4>
				<a href="/JspBlog/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		</c:forEach>

	<br />
	
	<c:set var="startNum"  value="${page-(page-1)%5 }" />
	
	
	
	<ul class="pagination justify-content-center">
	<c:choose>
	<c:when test="${param.page<=1 }">
<li class="page-item  "><a class="page-link"     onclick="alert('이전 페이지가 없습니다.');">Previous</a></li>
	</c:when>
	<c:otherwise>
		<li class="page-item "><a class="page-link" href="/JspBlog/board?cmd=list&page=${param.page-1 }">Previous</a></li>
	</c:otherwise>
	</c:choose>
	
	<c:choose>
	<c:when test="${lastPage <= param.page}">
		<li class="page-item  "><a class="page-link"     onclick="alert('다음 페이지가 없습니다.');">Next</a></li>
	</c:when>
	<c:otherwise>
		<li class="page-item"><a class="page-link" href="/JspBlog/board?cmd=list&page=${param.page+1}">Next</a></li>
	</c:otherwise>
	</c:choose>
		
		
		
		
	</ul>
	
	
	<h2>현재페이지:${param.page}</h2>
</div>





</body>
</html>