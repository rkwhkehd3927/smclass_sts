<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script>
			if("${param.logout}" == "1"){
				alert("로그아웃");
				location.href="/";
			}
		</script>
	</head>
	<body>
		<div><img src="/images/r01.jpg"></div>
		<h2>메인페이지</h2>
		<div>session_id: ${session_id}</div>
		<div>session_name: ${session_name}님 환영~😎
<%-- 		<div>loginChk: ${chk}</div> --%>
<%-- 		<div>loginChk: ${param.chk}</div> --%>
<%-- 		<div>logoutChk: ${logoutChk}</div> --%>
		
		<ul>
			<c:if test="${session_id == null }">
				<li><a href="/rpage">rpage</a></li>
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/member/member">회원가입</a></li>
				<hr>
<!-- 				<li><a href="/member/mlist">회원리스트</a></li> -->
				<li><a href="/board/blist">게시판</a></li>
				<li><a href="/board/bwrite">게시글 작성</a></li>
			</c:if>
			<c:if test="${session_id != null }">
				<li><a href="/member/logout">로그아웃</a></li>
				<li><a href="/member/memInfo">회원정보</a></li>
				<li><a href="/board/blist">게시판</a></li>
<!-- 				<li><a href="/board/bwrite">게시글 작성</a></li> -->
			</c:if>	
		</ul>
		
		<h3>이미지 보기</h3>
		<div>
			<img src="/upload/${param.fname}"/>
		</div>
	
	</body>
</html>