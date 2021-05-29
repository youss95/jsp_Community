<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
    <link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
    <style>
    #editor {
height:500
}
#gogo{
margin-top:20px;
margin-right:20px;
float:right
}
    </style>
</head>
<%@include file="../header.jsp" %>
<br>
<div class="container">
  <h2>글쓰기</h2>
  <form action="/DogCat/blog?cmd=write&user_no=${sessionScope.sessionUser.user_no}"  method="post"  enctype="multipart/form-data" >
    <div class="form-group">
      <label for="title">title:</label>
      <input type="text" class="form-control" id="title" placeholder="제목을 입력해 주세요" name="bTitle" required>
    </div>
    
   
   
 


  <textarea id="editor" class="form-control" rows="4" id="content" name="bContent"></textarea>
 

<br>
  파일: <input type="file" name="file" >
  <br><br>
  
   <button type="submit"  id="gogo" class="btn btn-primary">등록</button>
   
  
    </form>
    </div>
<script>
  var quill = new Quill('#editor', {
    theme: 'snow'
  });
  
  
  
</script>
</body>
</html>