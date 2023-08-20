<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list");
%>

<!-- 나중에 이 부분은 부트스트랩의 테이블 속성 연결해서 완전한 디자인으로 작성 -->
<h2>회원 전체 명단 보기</h2>
<table>
<%
	for(MemberVO vo : list){
%>
<tr>
	<td><%= vo.getId() %></td>
	<td><%= vo.getName() %></td>
	<td><%= vo.getAddress() %></td>
</tr>

<%
}
%>
</table>
</body>
</html>