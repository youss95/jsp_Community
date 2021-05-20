<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<br/><br/><br/><br/>
<div class="container">
<form action="/ShoppingWeb/product?cmd=upload" method="post" enctype="multipart/form-data">
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
  
  파일: <input type="file" name="file"><br>
  

  
  <br>
  <button type="submit" class="btn btn-primary">등록하기</button>
  <button type="reset" class="btn btn-primary">다시하기</button>
</form>
</div>



</body>
</html>