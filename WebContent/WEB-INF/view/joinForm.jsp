<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		width:120px;
		float: left;
	}
	.error, .error2{
		color: red;
		font-size: 12px;
		display: none;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#f1").submit(function(){
			$(".error").css("display","none");
			$(".error2").css("display","none");
			
			var id = $("input[name='memberid']").val();
			var name = $("input[name='name']").val();
			var passwd = $("input[name='password']").val();
			var confirmpasswd = $("input[name='confirmPassword']").val();
			//아이디
			if(id==""){
				$("input[name='memberid']").nextAll(".error").css("display","inline");
				return false; //submit을 막음
			}
			var regId = /^[a-z0-9]{7,15}$/i;
			if(regId.test(id)==false){
				$("input[name='memberid']").nextAll(".error2").css("display","inline");
				return false;
			}
			//이름
			if(name==""){
				$("input[name='name']").next().css("display","inline");
				return false;
			}
			var regName = /^[가-힣]{2,5}$/;
			if(regName.test(name)==false){
				$("input[name='name']").nextAll(".error2").css("display","inline");
				return false;
			}
			//비밀번호
			if(passwd==""){
				$("input[name='password']").next().css("display","inline");
				return false;
			}
			var regPass = /^[a-zA-Z0-9!@#$%^&]{8,20}$/i;
			if(regPass.test(passwd)==false){
				$("input[name='password']").nextAll(".error2").css("display","inline");
				return false;
			}
			//비밀번호 체크
			if(confirmpasswd==""){
				$("input[name='confirmPassword']").next().css("display","inline");
				return false;
			}
			if(passwd!=confirmpasswd){
				$("input[name='confirmPassword']").nextAll(".error2").css("display","inline");
				return false;
			}
			
			return true;
		});
		
		$("#duplicatedIdBtn").click(function(){
			var id = $("input[name='memberid']").val();
			
			$.ajax({
				url:"duplicatedId.do",
				data:{"id":id},
				dataType:"json",
				success:function(data){
					console.log(data);
					if(data.result==true){
						alert("사용중인 아이디입니다.");
					}else{
						alret("ID를 사용할 수 있습니다.");
					}
				}
			})
			
		})
	})
</script>
</head>
<body>
	<form action="join.do" method="post" id="f1">
		<p>
			<label>아이디</label>
			<input type="text" name="memberid">
			<button type="button" id="duplicatedIdBtn">중복체크</button>
			<span class="error">ID를 입력하세요</span>
			<span class="error2">영어, 숫자(7~15)자리를 입력해주세요.</span>
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="name">
			<span class="error">이름을 입력하세요</span>
			<span class="error2">한글(1~5)자리를 입력해주세요.</span>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password">
			<span class="error">비밀번호를 입력하세요</span>
			<span class="error2">영어, 숫자, 특수문자(8~20)자리를 입력해주세요.</span>
		</p>
		<p>
			<label>비밀번호 확인</label>
			<input type="password" name="confirmPassword">
			<span class="error">비밀번호확인을 입력하세요</span>
			<span class="error2">비밀번호가 일치하지 않습니다.</span>
		</p>
		<p>
			<input type="submit" value="회원가입">
		</p>
	</form>
</body>
</html>