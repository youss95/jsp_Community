<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>

<br/><br/><br/><br/>
<div class="container">
<form action="/ShoppingWeb/user?cmd=login" method="post">
  <div class="form-group">
    <label for="id">아이디:</label> 
    <input type="text" class="form-control" placeholder="Enter id" id="user_id" name="user_id">
  </div>
  
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="user_password"  name="user_password">
  </div>
<br>
  <button type="submit" class="btn btn-primary">로그인</button>
  <button type="reset" class="btn btn-primary">다시입력</button>
</form>
</div>
</body>
</html>