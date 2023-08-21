<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL Result Page</h2>
<b>1. JSP 기본 Element (이전 방식)</b><br>
ID :: <%= request.getParameter("myId")  %><br>

<b>2. JSP EL</b><br>
<!-- 000.getAttribute("myId") -->
ID :: ${myId}<br>
<!-- .getParameter("myId") -->
ID :: ${param.myId}<br>
<br>

<hr>
<b>3. JSP Menu(checkBox)기본 Element (이전 방식)</b><br>
<% 
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus){
	
%>

<%=menu %>
<% 
	}
%>

<br>
<b>4. JSP Menu(checkBox) EL</b><br>
선택한 메뉴<br>
${paramValues.menu[0]}
${paramValues.menu[1]}
${paramValues.menu[2]}
${paramValues.menu[3]}
<!-- 선택 안 해도 null에러 뜨는게 아니라 그냥 출력 X 따라서 에러 안 남. -->
</body>
</html>