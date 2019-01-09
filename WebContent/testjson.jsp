<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn1").click(function(){
			$.ajax({
				url:"article/readjson.do",
				type:"get",
				data:{"no":22},
				dataType:"json",
				success:function(json){
					console.log(json);
					$("#wrap").append(json.article.writer_id);
				}
			})
		})
		
		$("#btn2").click(function(){
			$.ajax({
				url:"article/listjson.do",
				type:"post",
				dataType:"json",
				success:function(json){
					console.log(json);
					//배열 json은 인덱스로 가져와야함
					$("#wrap").append(json[4].title);
					
					$(json).each(function(index, obj){
						$("#list").append("<li>"+obj.title+"</li>");
					})
				}
			})
		})
	})
</script>
</head>
<body>
	<button id="btn1">json read</button>
	<button id="btn2">json list</button>
	<div id="wrap"></div>
	<ul id="list">
	
	</ul>
</body>
</html>