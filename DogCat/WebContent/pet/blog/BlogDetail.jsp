<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/animate.css">
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/magnific-popup.css">


    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/jquery.timepicker.css">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/flaticon.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pet/css/style.css">
    <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
  <script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  
  <style>
  #replyuser{
  border:1px solid black;
  }
  #con{
   border:1px solid black;
  }
  </style>
</head>
<%@include file="../header.jsp" %>

	
    <br/>
    <h3 class="m-2">
    <b>title: ${detailList.title}</b>
    </h3>
    <hr/>
    <div class="form-group">
    <div class="m-2">내용: ${detailList.content }</div>
    </div>
    <hr/>
<h6 class="m-2">
    작성자: <i></i>  &nbsp; 조회수:${detailList.hit}<i></i>
    </h6>
    <br>
    <form action="/DogCat/reply?cmd=plusReply&user_id=${sessionScope.sessionUser.user_id}&user_no=${sessionScope.sessionUser.user_no}&blognum=${detailList.blognum}" method="post">
     <div id="replybox">
        <div id="replyuser">
            <div id="userid" contenteditable="true"></div>
        </div>
        <div id="replycon">
            <input type="text" id="con"  name="content"></div>
            <div id="btn">
                <button type="submit">Reply</button>
            </div>
        </div>
    </div><br><hr>
    </form>
    <button id="replBtn" class="btn btn-primary">댓글보기</button>
    <div id="reply"></div>
    <script>
    
    $(function(){
        $("#replBtn").on("click",function(){
        
            let a = $("<div id=box><div id=replycon2><div id=replyhead>"+$("#userid").html()+
                " 님의 글</div><div id=con2>"+$("#con").html()+"</div></div><button class=delete>삭제</button></div>");
            $("#reply").append(a);
            $("#con").html("");
            $("#userid").html("");
        })
        $(document).on("click",".delete",function(e){
            $(this).parent().remove();
        })
    })
   

    </script>
</body>
</html>