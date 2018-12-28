<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
		margin: 0 auto;
		width:400px;
	}
	fieldset{
		padding: 20px;
	}
	label{
		display: block
	}
	
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/article/insert.do" method="post"><!-- 프로젝트명부터 입력하면 주소전체가 바뀜, 없으면 마지막 슬러시를 기점으로 바뀜 -->
		<fieldset>
			<p>
				<label>제목</label>
				<input type="text" name="title" value="">
			</p>
			<p>
				<label>내용</label>
				<textarea rows="10" cols="45" name="content"></textarea>
			</p>
			<p>
				<input type="submit" value="새글 등록">
			</p>
		</fieldset>	
	</form>
</body>
</html>