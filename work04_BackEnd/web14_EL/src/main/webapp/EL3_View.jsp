<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>정보출력</b><br>
${vo}

ID :: ${vo.id} <!-- .getAttribute("vo").getId() -->
Name :: ${vo.name}<!-- .getAttribute("vo").getName() -->
Address :: ${vo.address}
</body>
</html>