<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="../html/header.jsp" %>
<div class="container">
 
  <div class="card" style="width:400px">
    <img class="card-img-top" src="<%=request.getContextPath() %>/upload/${detailList.filename}" alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">${detailList.product_name}</h4>
    <div id="product_price">price: ${detailList.product_price } 원</div>
    <div id="product_color">color: ${detailList.product_color } </div>
    <div id="product_size">size: ${detailList.product_size } </div>

      <a href="/ShoppingWeb/product?cmd=jacket" class="btn btn-primary stretched-link" id="back">뒤로가기</a>
    </div>
  </div>
</div>



</body>
</html>