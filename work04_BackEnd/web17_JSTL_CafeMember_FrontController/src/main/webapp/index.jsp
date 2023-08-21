<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@
    taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
a:hover {
  color: hotpink;
}

</style>
</head>
<body>
<div class="container">
	<div class="jumbotron" align="center">
		<h1> Cafe Member Using FrontController Pattern</h1>
	</div>

	<!-- 인증에 상관없이 사용할 수 있는 권한 -->
	<p><a href="register.jsp">회원 가입 하기</a></p>	
	
	<!-- 로그인 된 상태라면 !empty vo = session.getAttribute("vo") != null  -->
	<!-- 로그인 되지 않은 상태라면 -->
	<c:choose>
		<c:when test="${!empty vo}">
			
		    <p><a href="find.jsp">회원 검색 하기</a></p>
		    <p><a href="front.do?command=showAll">전체 회원 보기</a></p>
		</c:when>
		
		<c:otherwise>
			<p><a href="login.jsp">로그인 하기</a></p>
   			<p><a href="update.jsp">회원 정보 수정 하기</a></p>
		</c:otherwise>
	</c:choose>
		
    
   

</div>

</body>
</html>





