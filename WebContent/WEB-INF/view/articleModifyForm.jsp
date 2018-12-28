<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		padding: 5px;
	}
</style>
</head>
<body>
	<form action="modify.do?article_no=${article.article_no }" method="post">
		<table>
			<tr>
				<td>번호</td>
				<td>${article.article_no }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${article.writer_name}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
				<input type="text" name="title" value="${article.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="50" name="content">${content.content }</textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>