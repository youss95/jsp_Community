<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   	 <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<%@include file="../header.jsp" %>

<div class="container">
<form action="/DogCat/product?cmd=uploadProduct" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="id">카테고리:</label> 
    <input type="text" class="form-control" placeholder="카테고리입력" id="product_category" name="product_category">
  </div>
  
  <div class="form-group">
    <label for="pwd">수량:</label>
    <input type="text" class="form-control" placeholder="수량입력" id="product_stock"  name="product_stock">
  </div>
  
  <div class="form-group">
    <label for="pwd">이름:</label>
    <input type="text" class="form-control" placeholder="상품이름 입력" id="product_name" name="product_name">
  </div>
  
<div class="form-group">
    <label for="pwd">색상:</label>
    <input type="text" class="form-control" placeholder="색상 입력" id="product_color" name="product_color">
  </div>
 
  
  <div class="form-group">
    <label for="pwd">사이즈:</label>
    <input type="text" class="form-control" placeholder="사이즈 입력" id="product_size" name="product_size">
  </div>
  
  <div class="form-group">
    <label for="pwd">가격:</label>
    <input type="text" class="form-control" placeholder="가격 입력" id="product_price" name="product_price">
  </div>
  <div class="form-group">
			<label for="content">content:</label>
			<textarea id="summernote" class="form-control" rows="5" id="content" name="pDetail"></textarea>
		</div>
  
  
  
  파일: <input type="file" name="file"><br>
  

  
  <br>
  <button type="submit" class="btn btn-primary">등록하기</button>
  <button type="reset" class="btn btn-primary">다시하기</button>
</form>
</div>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            placeholder: '글 작성',
            tabsize: 2,
            height: 500
          });
    });
  </script>
</body>

</html>