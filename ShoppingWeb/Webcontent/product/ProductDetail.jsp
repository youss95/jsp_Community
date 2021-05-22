<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="../html/header.jsp" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <br><br><br><br>
<div class="container">
  <div class="card" style="width:400px">
    <img class="card-img-top" src="<%=request.getContextPath() %>/upload/${detailList.filename}" alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">${detailList.product_name}</h4>
    <div id="product_price">price: ${detailList.product_price } 원</div>
    <div id="product_color">color: ${detailList.product_color } </div>
    <div id="product_size">size: ${detailList.product_size } </div>

     
    
    <button type="button" class="btn btn-info" onclick="location.href='/ShoppingWeb/product?cmd=jacket'">뒤로가기</button>
   
   <c:choose>
   <c:when test="${sessionScope.sessionUser != null}">
    <a href="/ShoppingWeb/cart?cmd=bascket&product_no=${detailList.product_no}&user_no=${sessionScope.sessionUser.user_no}"onclick="test()" class="btn btn-primary ">장바구니</a>
   </c:when>
   
   <c:otherwise>
    <a href="/ShoppingWeb/user/LoginForm.jsp"onclick="거부()" class="btn btn-primary ">장바구니</a>
   </c:otherwise>
   </c:choose>
   
    
    <button type="button" class="btn btn-info" onclick="test()"><i class="fas fa-shopping-bag">구매하기</i></button>
    </div>
  </div>
 
  
<script>
    function test() {
        if (!confirm("해당 상품을 장바구니에 담으시겠습니까?")) {
            alert("장바구니 담기를 취소합니다.");
        } else {
            alert("장바구니에 담겨졌습니다.");
      
        }
    }
    
    function 거부(){
    alert("로그인 부터 하세요")
    }
    
    
    function back(){
    	if(!confirm("뒤로 가시겠습니까?")){
    		
    	} else{
    		location.href="/ShoppingWeb/product/list.jsp";
    	}
    }
    
    function back(){
    	if(!confirm("구매 페이지로 이동하시겠습니까?")){
    		
    	} else{
    		
    	}
    }
</script>
</div>



</body>
</html>