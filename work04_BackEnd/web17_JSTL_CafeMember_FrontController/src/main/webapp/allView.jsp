<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 나중에 이 부분은 부트스트랩의 테이블 속성 연결해서 완전한 디자인으로 작성 -->
<h2>회원 전체 명단 보기</h2>
<table>
<tbody>
	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.address}</td>
		</tr>
		
	</c:forEach>
</tbody>
</table>
</body>
</html>