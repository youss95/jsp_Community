
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<!-- 해당 페이지로 직접 url  접근을 하면 또 파일 내부에서 세션 체크를 해야함 -->
<!-- .jsp로 접근하는 모든 접근을 막아야 한다. -->

<div class="container">
	<form action="/JspBlog/board?cmd=update" method="POST">
	<input type="hidden" name="id" value="${updateList.id}"/>  
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" placeholder="title" id="title" name="title" value="${updateList.title }">
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea id="summernote" class="form-control" rows="5" id="content" name="content">
			${updateList.content}
			</textarea>
		</div>
	
		<button type="submit" class="btn btn-primary">글쓰기 수정</button>
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


