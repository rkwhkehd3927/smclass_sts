<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<script>
			if("${param.chk}" =="0"){
				alert("아이디 또는 패스워드 불일치, 다시 로그인하라.")
			}
		</script>
	</head>
	<body>
		<h2>로그인 페이지</h2>
<%-- 		<div>session_id: ${session_id}</div> --%>
<%-- 		<div>loginChk: ${loginChk}</div> --%>
<%-- 		<div>logoutChk: ${logoutChk}</div> --%>
		
		<form action="./login" method="post">
			<label>아이디</label>
			<input type="text" name="id"><br/>
			<label>패스워드</label>
			<input type="password" name="pw"><br/>
			<input type="submit" value="로그인">
		</form>
		
		<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>