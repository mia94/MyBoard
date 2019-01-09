<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- filelist = arraylist -->
	<c:forEach var="file" items="${fileList }">
		<p>${file }<br>
			<img src="${pageContext.request.contextPath }/upload/${file}">
		</p>
	</c:forEach>
</body>
</html>