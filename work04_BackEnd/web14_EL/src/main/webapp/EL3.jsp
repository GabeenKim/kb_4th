<%@page import="src.main.java.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 서블릿 로직 순서
	1. 폼 값 받아서
	2. 받은 값으로 vo 생성 
	3. dao 리턴 받고 비지니스 로직 호출
	4. 리턴 값을 Attribute에 바인딩.
	5. 네비게이션 - 결과 페이지 연결
 -->
 
 <%
 MemberVO vo = new MemberVO("1","1","1","1");
 request.setAttribute("vo", vo);
 
 request.getRequestDispatcher("EL3_View.jsp").forward(request, response);
 %>
</body>
</html>