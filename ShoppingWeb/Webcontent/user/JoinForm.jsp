<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<br/><br/><br/><br/>
<div class="container">
<form action="/ShoppingWeb/user?cmd=join" method="post" onsubmit="valid()">
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
		
var isChecking = false;

function valid(){
	if(isChecking == false){
		alert("아이디 중복체크를 해주세요");
	}
	return isChecking;
}

function idCheck(){
	//db에서확인해서 정상이면 isChecking = true
	//새로고침이 아닌 데이터만 필요하기 때문에 ajax 통신 
	
	var username = $("#user_id").val();   //documnet.queryselector("username")
	
	$.ajax({
		type: "POST",
		url: "/ShoppingWeb/user?cmd=usernameCheck",
		data: username,
		contentType: "text/plain; charset=utf-8",
		dataType: "text"  // 응답 받을 데이터의 타입을 적으면 자바스크립트 오브젝트로 파싱해줌.
	}).done(function(data){
		if(data === 'ok'){ // 유저네임 있다는 것
			alert('유저네임이 중복되었습니다.')
			isChecking=false;
		}else{
			isChecking = true;
		
			alert("해당 유저네임을 사용할 수 있습니다.")
		}
	});
}
		
		
		
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