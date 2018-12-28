<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{
		text-decoration: none;
		font-size: 1.1em;
		color:gray;
		font-weight: bold;
	}
</style>
</head>
<body>
	<c:if test="${AUTH == null }">
		<a href="join.do">[회원가입]</a><br>
		<a href="login.do">로그인 하기</a>
	</c:if>
	<c:if test="${AUTH != null }">
		<p>${AUTH }님. 반갑습니다.</p><br>
		<a href="changePwd.do">[비밀번호 변경]</a><br>
		<a href="memberlist.do">회원리스트보기</a><br>
		<a href="logout.do">로그아웃</a>
		<br>
		<a href="article/insert.do">게시글 작성하기</a><br>
		<a href="article/list.do">게시글 목록 보기</a>
	</c:if>
	
	
</body>
</html>