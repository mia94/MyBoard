<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	fieldset {
		width:300px;
		padding: 20px;
	}
	label{
		width:90px;
		float: left;
	}
	P:LAST-CHILD{
		text-align: center; 
	}
	P:LAST-CHILD input{
		width:100px;
		height: 35px;
		border-radius: 10px;
		border:2px solid gray;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<form action="login.do" method="post">
		<fieldset>
			<p>
				<label>아이디</label>
				<input type="text" name="id">
			</p>
			<p>
				<label>비밀번호</label>
				<input type="password" name="password">
			</p>
			<p>
				<input type="submit" value="로그인">
			</p>
		</fieldset>
	</form>
	
</body>
</html>