<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	td{
		border:1px solid black;
		padding: 10px;	
	}
</style>
</head>
<body>
	<table>
		<c:forEach var="item" items="${result }">
			<tr>
				<td>${item.memberid }</td>
				<td>${item.name }</td>
				<td>${item.password }</td>
				<td><fmt:formatDate value="${item.regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>