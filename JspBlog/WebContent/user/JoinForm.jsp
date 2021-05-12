<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<div class="container">

<form action="/JspBlog/user?cmd=join" method="post"  onsubmit="return valid()"> <!-- submit 될때 무조건 실행될 valid() -->
  <div class="d-flex justify-content-end">
  <button type="button" class="btn btn-info" onClick="usernameCheck()">중복체크</button>
  </div>
  <div class="form-group">
    <input type="text" name="username" id="username" class="form-control" placeholder="사용하실 아이디를 입력해 주세요."  required>
  </div>
  
  <div class="form-group">
    <input type="password"  name="password"  id="pw1" class="form-control" placeholder="사용하실 비밀번호를 입력해 주세요." required >
  </div>
  
   <div class="form-group">
    <input type="password"  name="password2"  id="pw2" class="form-control" placeholder="비밀번호 확인." required >
  </div>
  <div id="result"></div><br/>
  <div class="form-group">
    <input type="email" name="email" class="form-control" placeholder="사용하실 이메일을 입력해 주세요."  required>
  </div>
  <!-- 부트스트랩 플랙스 -->
  <div class="d-flex justify-content-end">
  <button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
  </div>
  <div class="form-group">
    <input type="text"  name="address"  id="address" class="form-control" placeholder="사용하실 주소를 입력해 주세요."  required readonly>
  </div>
  <br/>
 
  
  <button type="submit" class="btn btn-primary">회원가입완료</button>
</form>
</div>

<script>
var p1 = document.getElementById("pw1");
var p2 =document.getElementById("pw2");
let result = document.getElementById("result");

p2.onkeyup = function(){
    if(p1.value != p2.value){
        result.innerHTML = "비밀번호 다릅니다. 다시 확인해 주세요!"
        	 result.setAttribute("style","color:red")
    } else if(p1.value == p2.value){
        result.innerHTML="사용할 수 있는 비밀번호 입니다."
        	 result.setAttribute("style","color:blue")
    }
}


/* function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/JspBlog/user/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
}


function jusoCallBack(roadFullAddrm){
	var addressEl =	document.querySelector("#address");
		addressEl.value = roadFullAddr;
		
} */
var isChecking = false;

function valid(){
	if(isChecking == false){
		alert("아이디 중복체크를 해주세요");
	}
	return isChecking;
}

function usernameCheck(){
	//db에서확인해서 정상이면 isChecking = true
	//새로고침이 아닌 데이터만 필요하기 때문에 ajax 통신 
	
	var username = $("#username").val();   //documnet.queryselector("username")
	
	$.ajax({
		type: "POST",
		url: "/JspBlog/user?cmd=usernameCheck",
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
function goPopup() {
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/JspBlog/user/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}
function jusoCallBack(roadFullAddr) {
	var addressEl = document.querySelector("#address");
	addressEl.value = roadFullAddr;
}

</script>
</body>
</html>