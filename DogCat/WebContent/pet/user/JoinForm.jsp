<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!DOCTYPE html>
<html lang="en">
  <head>
    <title>Pet Sitting - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
    <link rel="stylesheet" href="../css/animate.css">
    
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">


    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../css/jquery.timepicker.css">

    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/style.css">
  </head>
    
    
<%@include file="../header.jsp" %>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<br/><br/><br/><br/>
<div class="container">
<form action="/DogCat/user?cmd=join" method="post" onsubmit="valid()">
  <div class="form-group">
    <label for="id">아이디:</label> <input type="button" id="idcheck"  onclick="idCheck();" value="중복검사">
    
    <input type="text" class="form-control" placeholder="Enter id" id="user_id" name="user_id" required>
  </div>
  
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="user_password"  name="user_password" required>
  </div>
  
  <div class="form-group">
    <label for="pwd">이메일:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="user_email" name="user_email" required>
  </div>
  
  <div class="form-group">
    <label for="pwd">주소:</label><br>
     <input type="text" id="sample4_postcode" placeholder="우편번호">
  <input type="button"  id="search" onclick="sample4_execDaumPostcode()" value=" 주소검색"><br>
    <input type="text" class="form-control" placeholder="Enter address" id="user_address" name="user_address" required>
  </div>
 
  
  <div class="form-group">
    <label for="pwd">상세주소:</label>
    <input type="text" class="form-control" placeholder="Enter address" id="user_addressDetail" name="user_addressDetail" required>
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
</script>