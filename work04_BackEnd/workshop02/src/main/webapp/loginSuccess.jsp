<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
<%
	String id = request.getParameter("id");
%>
<h2 style="text-align: center; margin-top: 100px;"><%=id%>님이 로그인 되었습니다!!!</h2>

<br><br>
<p style="text-align: center"><a href="#">도서 등록</a></p>
<p style="text-align: center"><a href="#">로그아웃</a></p>

</body>
</html>