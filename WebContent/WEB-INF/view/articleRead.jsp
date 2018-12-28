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
		width:400px;
	}
	td{
		border:1px solid black;
		padding: 5px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#delBtn").click(function(){
			var del = confirm("정말 삭제하시겠습니까?");
			if(del==true){
				$("#delBtn").prop("disabled",false);
			}else{
				$("#delBtn").prop("disabled",true);
			}
		})
	})
</script>
</head>
<body>
	<!-- 번호, 작성자이름, 제목, 내용 -->
		<table>
			<TR>
				<td>번호</td>
				<td>${map.article.article_no }</td>
			</TR>
			<TR>
				<td>이름</td>
				<td>${map.article.writer_name }</td>
			</TR>
			<TR>
				<td>제목</td>
				<td>${map.article.title }</td>
			</TR>
			<TR>
				<td>내용</td>
				<td>${map.content.content }</td>
			</TR>
		</table>
		<a href="${pageContext.request.contextPath }/article/list.do">[목록]</a>
		<a href="${pageContext.request.contextPath }/article/modify.do?article_no=${map.article.article_no }">[게시글 수정]</a>
		<a href="${pageContext.request.contextPath }/article/delete.do?article_no=${map.article.article_no }" id="delBtn">[게시글 삭제]</a>
</body>
</html>