<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../html/header.jsp" %>
    <!-- admin으로 수정하수 있어야 한다. -->
<div class="container">
  <h2>Stretched Link in Card</h2>
  <p>Add the .stretched-link class to a link inside the card, and it will make the whole card clickable (the card will act as a link):</p>
  <div class="card" style="width:300px">
    <img class="card-img-top" src="../resources/images/J1.jpg" alt="Card image" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">John Doe</h4>
      <p class="card-text">Some example text some example text. John Doe is an architect and engineer</p>
      <a href="#" class="btn btn-primary stretched-link">상세보기</a>
    </div>
  </div>
</div>

</body>
</html>