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
<h2><%=id%>님이 로그인 되었습니다!!!</h2>
<p></p>
<p></p>
<h3><a href="#">도서 등록</a></h3>
<h3><a href="#">로그아웃</a></h3>

</body>
</html>