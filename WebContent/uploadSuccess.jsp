<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	file1 : ${file1 }<br>
	file2 : ${file2 }<br>
	desc : ${desc }
	
	<p>
		<img src="${pageContext.request.contextPath }/upload/${file1 }"> 
	</p>
</body>
</html>