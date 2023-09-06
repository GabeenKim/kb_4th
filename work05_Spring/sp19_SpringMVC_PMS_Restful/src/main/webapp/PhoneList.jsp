<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<table>
		<thead>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		</thead>
		<!--  forEach 사용 -->
		<tbody>
			<c:forEach items="${phones}" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}</td>
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td>
				<td><input type ="checkbox" data-num="${phone.num}"></td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
	<a href="regPhone.do">추가 등록</a>&nbsp;
	<a href="#" id="selectedDel">선택항목삭제</a>
</body>

<!-- 삭제 버튼시 비동기 처리 -->
<script>
	//스크립트 태그가 맨 밑에 있기에, onload 함수는 필요 없음. 맨 마지막에 실행되기 때문 
	$('#selectedDel').click(function() {
		//checkbox 선택된 num 값들을 받아온다...
		var param = "";
		$('input[type=checkbox]:checked').each(function (index, item) {
			param = param += "&num="+$(item).attr('data-num');
		})//each
		
		$.ajax({
			type :'post',
			url:'deleteAjax.do',
			data : param,
			
			success : function(result) {
				location.reload(); //해당 페이지가 reloadable된다.
			}//callback
		});//ajax
	});//click
</script>
</html>