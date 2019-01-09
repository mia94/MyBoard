<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.do"enctype="multipart/form-data" method="post"><!-- 파일 업로드시 반드시 enctype필요, post형식으로 보내기 -->
		<p>
			<label>파일명선택</label>
			<input type="file" name="file1">
		</p>
		<p>
			<label>파일명 선택 2</label>
			<input type="file" name="file2">
		</p>
		<p>
			<label>파일 설명</label>
			<input type="text" name="desc">
		</p>
		<p>
			<input type="submit" value="전송">
		</p>
	</form>
	
	<hr>
	
	<form action="uploadM.do" enctype="multipart/form-data" method="post">
		<p>
			<label>파일명선택</label>
			<input type="file" name="file1" multiple="multiple">
		</p>
		<p>
			<label>파일 설명</label>
			<input type="text" name="desc">
		</p>
		<p>
			<input type="submit" value="전송">
		</p>
	</form>
</body>
</html>