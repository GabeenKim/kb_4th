<%@page import="web.servlet.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 결과 페이지므로 Attribute에 바인딩 된 데이터를 받아오는 작업부터 해야 함. -->

<%

Member mem1 = (Member)request.getAttribute("mem1");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 폼 값에 입력된 값 출력 -->
<h2><b><%= request.getParameter("address") %></b>에 사는 멤버 정보입니다...</h2>
<p></p>
이름 : <%=mem1.getName()%><br>
나이 : <%=mem1.getAge()%>

</body>
</html>