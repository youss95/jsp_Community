<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  
  <body>

    <div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
							<a href="#" class="mr-2"><span class="fa fa-phone mr-1"></span> +00 1234 567</a> 
							<a href="#"><span class="fa fa-paper-plane mr-1"></span> youremail@email.com</a>
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="social-media">
			    		<p class="mb-0 d-flex">
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
			    		</p>
		        </div>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-light ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	    	<a class="navbar-brand" href="/DogCat/pet/index.jsp"><span class="flaticon-pawprint-1 mr-2"></span>Pet sitting</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="fa fa-bars"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        	<li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
	        	<li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
	        	<li class="nav-item"><a href="vet.html" class="nav-link">Veterinarian</a></li>
	        	<li class="nav-item"><a href="services.html" class="nav-link">Services</a></li>
	          <li class="nav-item"><a href="gallery.html" class="nav-link">Gallery</a></li>
	          <li class="nav-item"><a href="/DogCat/product?cmd=productList" class="nav-link">스토어</a></li>
	          <li class="nav-item"><a href="/DogCat/blog?cmd=blogList" class="nav-link">블로그</a></li>
	          <c:choose>
	          <c:when test="${sessionScope.sessionUser != null&&sessionScope.sessionUser.userRole.equals('admin') }">
	            <li class="nav-item"><a href="/DogCat/user?cmd=JoinForm" class="nav-link">관리페이지</a></li>
	          <li class="nav-item"><a href="/DogCat/user?cmd=LoginForm" class="nav-link">로그아웃</a></li>
	          </c:when>
	          
	          <c:when test="${sessionScope.sessionUser != null&&sessionScope.sessionUser.userRole.equals('normal') }">
	            <li class="nav-item"><a href="/DogCat/user?cmd=JoinForm" class="nav-link">마이페이지</a></li>
	          <li class="nav-item"><a href="/DogCat/user?cmd=LoginForm" class="nav-link">로그아웃</a></li>
	          </c:when>
	          
	          <c:otherwise>
	           <li class="nav-item"><a href="/DogCat/user?cmd=JoinForm" class="nav-link">회원가입</a></li>
	          <li class="nav-item"><a href="/DogCat/user?cmd=LoginForm" class="nav-link">로그인</a></li>
	          </c:otherwise>
	          </c:choose>
	          
	         
	        </ul>
	      </div>
	    </div>
	  </nav>