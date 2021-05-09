<%@page import="com.ksy.model.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
<h1>회원 리스트</h1>

<c:forEach var="bean" items="${list }">
회원아이디:${bean.id }<br/>
날짜:${bean.regdate }<br/>
이름:${bean.name }<br/>
이메일:${bean.email }<br/>
아이디:${bean.loginId }<br/>
비밀번호:${bean.loginPw }<br/>
레벨:${bean.adminlevel }<br/>
<hr/>

</c:forEach>
</body>
</html>