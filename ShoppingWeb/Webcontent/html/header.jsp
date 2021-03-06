<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Fredparry Cover by LEE SORA</title>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500&family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/html/style.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    
</head>

<body>
	<header>
		<ul class="menu">
			<li>
				<a href="/ShoppingWeb/product?cmd=jacket">남성</a>
				<ul class="menu_list">
					<li><a href="#">자켓</a></li>
					<li><a href="#">니트</a></li>
					<li><a href="#">후드/스웻셔츠</a></li>
					<li><a href="#">티셔츠</a></li>
					<li><a href="#">폴로</a></li>
					<li><a href="#">셔츠</a></li>
					<li><a href="#">바지</a></li>
				</ul>
			</li>
			<li>
				<a href="#">여성</a>
				<ul class="menu_list">
					<li><a href="#">자켓</a></li>
					<li><a href="#">니트</a></li>
					<li><a href="#">후드/스웻셔츠</a></li>
					<li><a href="#">셔츠</a></li>
					<li><a href="#">폴로</a></li>
					<li><a href="#">티셔츠</a></li>
					<li><a href="#">원피스/스커트</a></li>
					<li><a href="#">바지</a></li>
				</ul>
			</li>
			<li>
				<a href="#">신발</a>
				<ul class="menu_list">
					<li><a href="#">남성</a></li>
					<li><a href="#">여성</a></li>
					<li><a href="#">남여공용</a></li>
				</ul>
			</li>
			<li>
				<a href="#">가방/악세사리</a>
				<ul class="menu_list">
					<li><a href="#">가방</a></li>
					<li><a href="#">악세사리</a></li>
				</ul>
			</li>
			<li>
				<a href="#" class="t_red">세일</a>
				<ul class="menu_list">
					<li><a href="#">남성</a></li>
					<li><a href="#">여성</a></li>
					<li><a href="#">가방</a></li>
					<li><a href="#">악세사리</a></li>
				</ul>
			</li>
		</ul>
		<h1 class="logo">
			<a href="/ShoppingWeb/html/index.jsp">
				<img src="<%=request.getContextPath() %>/resources/images/logo.png" alt="프레디페리 로고 이미지">
			</a>
		</h1>
		<ul class="utils">
		<c:choose>
		<c:when test="${sessionScope.sessionUser != null&&sessionScope.sessionUser.userRole.equals('normal') }">
		<li><a href="#">${sessionScope.sessionUser.user_id }님 안녕👋</a></li>
		<li><a href="/ShoppingWeb/user?cmd=logout">로그아웃	</a></li>
		<li><a href="/ShoppingWeb/user?cmd=MyForm">마이페이지</a></li>
		
			<li><a href="/ShoppingWeb/cart?cmd=bascketForm&user_no=${sessionScope.sessionUser.user_no}">장바구니</a></li>
		</c:when>
		
		<c:when test="${sessionScope.sessionUser != null&&sessionScope.sessionUser.userRole.equals('admin') }">
		<li><a href="#">관리자 계정입니다.</a></li>
		<li><a href="/ShoppingWeb/product?cmd=UploadForm">상품등록</a></li>
		<li><a href="/ShoppingWeb/user?cmd=logout">로그아웃	</a></li>
		</c:when>
		
		<c:otherwise>
		<li><a href="/ShoppingWeb/user?cmd=LoginForm">로그인</a></li>
		<li><a href="/ShoppingWeb/user?cmd=JoinForm">회원가입</a></li>
		</c:otherwise>
		</c:choose>
			<li><a href="#">검색</a></li>
			
			
		</ul>
	</header>
    