<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../html/header.jsp" %>
    <!-- admin으로 수정하수 있어야 한다. -->
<div class="container">
  <c:forEach var="plist" items="${list}">
  <div class="card" style="width:300px">
    <img class="card-img-top" src="<%=request.getContextPath() %>/upload/${plist.filename}"  alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">${plist.product_name}</h4>
    <div class="price">price: ${plist.product_price }</div>
      <a href="#" class="btn btn-primary stretched-link">Detail</a>
    </div>
  </div>
  <img src="../upload/${plist.fileRealName}">
</c:forEach>
</div>

</body>
</html>