<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-collapse: collapse;
	}
	td, th{
		border:1px solid black;
		padding: 10px;
	}
	table td:FIRST-CHILD {
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="6"><a href="${pageContext.request.contextPath }/article/insert.do">[게시글 쓰기]</a></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성날짜</th>
			<th>수정날짜</th>
		</tr>
		
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.article_no }</td>
				<td><a href="read.do?no=${item.article_no }">${item.title }</a></td>
				<td>${item.writer_name }</td>
				<td>${item.read_cnt }</td>
				<td>${item.regdate }</td>
				<td>${item.moddate }</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>