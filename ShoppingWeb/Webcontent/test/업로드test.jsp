<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.File: %>
    <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String directory = application.getRealPath("../resources/images");
int maxSize = 1024*1024*100;
String encoding = "UTF-8";

MultipartRequest multipartRequest =
new MultipartRequest(request, directory, maxSize, encoding,
		new DefaultFileRenamePolicy());

String fileNmae = multipartRequest.getOriginalFileName("file"); //실제 사용자가 업로드하고자한 파일이름
String fileReaulName = multipartRequest.getFilesystemName("file"); //실제에 서버에 업로드가된 네임


%>
</body>
</html>