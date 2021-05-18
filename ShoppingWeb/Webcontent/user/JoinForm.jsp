<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>
<br/><br/><br/><br/>
<div class="container">
<form action="/ShoppingWeb/user?cmd=join" method="post">
  <div class="form-group">
    <label for="email">아이디:</label>
    <input type="text" class="form-control" placeholder="Enter id" id="user_id" name="user_id">
  </div>
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="user_password"  name="user_password">
  </div>
  
  <div class="form-group">
    <label for="pwd">이메일:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="user_email" name="user_email">
  </div>
  <div class="form-group">
    <label for="pwd">주소:</label>
    <input type="text" class="form-control" placeholder="Enter address" id="user_address" name="user_address">
  </div>
  <br>
  <button type="submit" class="btn btn-primary">회원가입</button>
  <button type="reset" class="btn btn-primary">다시하기</button>
</form>
</div>
</body>
</html>