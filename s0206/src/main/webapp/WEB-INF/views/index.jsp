<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<h4>세션: ${session_id}</h4>
		<c:if test="${session_id ==null}">	
			<div><a href="login">로그인</a></div>
			<div><a href="member">회원가입</a></div>
		</c:if>

		<c:if test="${session_id !=null}">
			<div><a href="logout">로그아웃</a></div>
			<div><a href="board">게시판</a></div>
			<div><a href="meminfo">회원정보</a></div>
		</c:if>

		
	</body>
</html>