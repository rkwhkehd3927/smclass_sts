<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>메인</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<h4>세션: ${session_id}</h4>
		<c:if test="${session_id ==null}">	
			<div><a href="/stuInput">성적정보</a></div>
			<div><a href="/login">로그인</a></div>
			<div><a href="/member">회원가입</a></div>
<!-- 			두가지 방식의 데이터 전달 -->
			<div><a href="/data?bno=10">데이터전달1</a></div> 
			<div><a href="/data2/100">데이터전달2</a></div>
			<div><a href="/data3/1,2,3">데이터전달3</a></div>
			<div><a href="/data4">데이터전달4-객체(list)</a></div>
		</c:if>

		<c:if test="${session_id !=null}">
			<div><a href="/logout">로그아웃</a></div>
			<div><a href="/meminfo">회원정보</a></div>
		</c:if>
	
	</body>
</html>