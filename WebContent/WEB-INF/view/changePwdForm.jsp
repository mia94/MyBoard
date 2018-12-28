<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{
		color:red;
		font-size: 12px;
	}
</style>
</head>
<body>
	<form action="changePwd.do" method="post">
		<p>
			<label>현재암호 : </label><br>
			<input type="password" name="oldPassword">
			<c:if test="${error != null }">
				<span class="error">현재 암호가 일치하지 않습니다.</span>
			</c:if>
		</p>
		<p>
			<label>새 암호 : </label><br>
			<input type="password" name="newPassword">
		</p>
		<input type="submit" value="암호 변경">
	</form>
</body>
</html>