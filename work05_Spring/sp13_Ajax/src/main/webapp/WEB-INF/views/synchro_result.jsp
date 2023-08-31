<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function () {
	//버튼 클릭하면 함수 호풀 
	$('#asynchro').click(function () {
		$.ajax({
			//req
			type :'get',
			url : 'asynchro',
			
			
			//res -> data를 객체 단위(즉, json타입)로 받아오기에 인자값 필수
			success : function (data) {
				/* alert(data); */
				var jsonData = JSON.parse(data);
				$('#resultView').html("<h3><font color=tamato>"+jsonData.person.name +
						"님이 사는 곳은 "+jsonData.person.address+"입니다.</font></h3>");
			}//callback;
			
		})//ajax
	});//click
});//ready...


</script>
</head>
<body>
<h3>${info}</h3>
<p></p>
<hr>
<p></p>

<input type="button" value="비동기통신 시작하기" id="asynchro">
<span id ="resultView"></span>
</body>
</html>