<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../html/header.jsp" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <div class="row">
    <div class="col">
 
   <br><br><br><br>
   <h1>장바구니</h1>
   
   
  <c:forEach var="clist" items="${showBascket }">
  <div class="card" style="width:300px">
    <img class="card-img-top" src="<%=request.getContextPath() %>/upload/${clist.filename}"  alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">${clist.product_name}</h4>
    <div class="price">price: ${clist.product_price }</div>
      <a href="/ShoppingWeb/product?cmd=detail&product_no=" class="btn btn-primary ">Detail</a>
    </div>
  </div>
</c:forEach>
 

</div>
 </div>
</div>






</body>
</html>