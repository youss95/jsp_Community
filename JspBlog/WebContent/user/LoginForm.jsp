<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>


<div class="container">

<form action="/JspBlog/user?cmd=login" method="post"  > <!-- submit 될때 무조건 실행될 valid() -->
  
  <div class="form-group">
    <input type="text" name="username" id="username" class="form-control" placeholder="사용하실 아이디를 입력해 주세요."  required>
  </div>
  
  <div class="form-group">
    <input type="password"  name="password"  id="pw1" class="form-control" placeholder="사용하실 비밀번호를 입력해 주세요." required >
  </div>
  
   
  
 
  
  <button type="submit" class="btn btn-primary">로그인</button>
</form>
</div>


</body>
</html>