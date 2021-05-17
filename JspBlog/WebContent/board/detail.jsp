<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../layout/header.jsp" %>

    <div class="container">
    <!--작성자의 게시물에 접속하였을때만 삭제 버튼이 보인다.  -->
    <c:if test="${sessionScope.sessionUser.id == detailList.userId }">
    <button onclick="deleteById(${detailList.id})" class="btn btn-danger">삭제</button>
    <a href="/JspBlog/board?cmd=updateForm&id=${detailList.id }" class="btn btn-warning">수정</a>
    </c:if>
    
    <!--script에 jsp코드가 들어가면 분리가 안된다.  -->
   
    
    
    <br/>
    <br/>
    <h6 class="m-2">
    작성자: <i>${detailList.username }</i>  &nbsp; 조회수:<i>${detailList.readCount }</i>
    </h6>
    <br/>
    <h3 class="m-2">
    <b>${detailList.title }</b>
    </h3>
    <hr/>
    <div class="form-group">
    <div class="m-2">${detailList.content }</div>
    </div>
    <hr/>
 
	<!-- 댓글 박스 -->
	<div class="row bootstrap snippets">
		<div class="col-md-12">
			<div class="comment-wrapper">
				<div class="panel panel-info">
					<div class="panel-heading m-2"><b>Comment</b></div>
					<div class="panel-body">
					
					<form action="/JspBlog/reply?cmd=save" method="post">
							<input type="hidden" name="userId" value="${sessionScope.sessionUser.id}" />
							<input type="hidden" name="boardId" value="${detailList.id}" />
							<textarea name="content" id="reply__write__form" class="form-control" placeholder="write a comment..." rows="2"></textarea>
							<br>

							<button class="btn btn-primary pull-right">댓글쓰기</button>
						</form>
						<script>
						
						
						/* function replySave(){
							$.ajax({
								type:"post",
								url:"/JspBlog/reply?cmd=save",
								data:
							}).done(function(result){
								
							})
						} */
						
						
						</script>
						<div class="clearfix"></div>
						<hr />
						<!-- 댓글 리스트 시작-->
						<ul id="reply__list" class="media-list">
						
						
							<!-- 댓글 아이템 -->
							<li class="media">	
								<img src="https://bootdey.com/img/Content/user_1.jpg" class="img-circle">		
								<div class="media-body">
									<strong class="text-primary"></strong>
									<p>
									${dto.content }
									</p>
								</div>
								<div class="m-2">
								
								<i onclick="#" class="material-icons ">delete</i>
								</div>
							</li>
					
						</ul>
						<!-- 댓글 리스트 끝-->
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 댓글 박스 끝 -->
    
    </div>
     <script>
    function deleteById(boardId){
    	
    	
    	
    	
    	
    	
    	$.ajax({
    		type:"post",
    		url:"/JspBlog/board?cmd=delete&id="+boardId,
    		dataType:"json"
    	}).done(function(result){
    		if(result.statusCode==1){
    			alert("성공적으로 삭제하였습니다.");
    		location.href="index.jsp";	
    		} else {
    			alert("삭제에 실패");
    		}
    	});
    }
    </script>
    </body>
    </html>