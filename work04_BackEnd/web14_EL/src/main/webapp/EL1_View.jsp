<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>1. JSP 기본 Element로 받아오기 (이전 방식)</b><BR>
ServletRequest에 바인딩 된 값 :: <%= request.getAttribute("RESULT1") %><BR>
HttpSession에 바인딩 된 값 :: <%= session.getAttribute("RESULT2") %><BR>

<br>
<b>2. JSP EL로 받아오기</b><br>
<!-- ${}는 제이쿼리 문법 -->
ServletRequest에 바인딩 된 값 :: ${RESULT1} <BR> <!-- ==request.getAttribute("RESULT1")  -->
HttpSession에 바인딩 된 값 ::${RESULT2} <BR> 
<!-- 
	request.getAttribute("RESULT2")를 찾는데 없음. 
	따라서 session.getAttribute("RESULT2")에서 찾고 바인딩 된 값이 있어서 출력. -->

연산도 가능함. :: ${RESULT2 + 100} <BR>
</body>
</html>