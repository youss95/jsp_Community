<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<br/><br/><br/><br/>
<div class="container">
<form action="/ShoppingWeb/user?cmd=mypage" method="post">
  <div class="form-group">
    <label for="id">아이디:</label> <input type="button" id="idcheck"  onclick="idCheck();" value="중복검사">
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
    <label for="pwd">주소:</label><br>
     <input type="text" id="sample4_postcode" placeholder="우편번호">
  <input type="button"  id="search" onclick="sample4_execDaumPostcode()" value=" 주소검색"><br>
    <input type="text" class="form-control" placeholder="Enter address" id="user_address" name="user_address">
  </div>
 
  
  <div class="form-group">
    <label for="pwd">상세주소:</label>
    <input type="text" class="form-control" placeholder="Enter address" id="user_addressDetail" name="user_addressDetail">
  </div>
  
  <br>
  <button type="submit" class="btn btn-primary">회원가입</button>
  <button type="reset" class="btn btn-primary">다시하기</button>
</form>
</div>

<script>
		
		document.getElementById("search").onclick = function() {
			new daum.Postcode(
					{
						oncomplete : function(data) {

							var roadAddr = data.roadAddress; // 도로명 주소 변수

							document.getElementById('sample4_postcode').value = data.zonecode;
							document.getElementById("user_address").value = roadAddr;

						}
					}).open();
		}
	</script>

</body>
</html>