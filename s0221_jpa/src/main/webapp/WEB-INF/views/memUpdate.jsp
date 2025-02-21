<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
	</head>
	<body>
		<h2>회원정보수정</h2>
		<form action="member" method="post">
			<label>아이디</label>
			<input type="text" name="id" value="${mdto.id}" readonly><br/>
			<label>패스워드</label>
			<input type="text" name="pw" ><br/>
			<label>이름</label>
			<input type="text" name="name" value="${mdto.name}" readonly><br/>
			<label>전화번호</label>
			<input type="text" name="phone" value="${mdto.phone}"><br/>
			<label>성별</label>
			<br/>
			<input type="radio" name="gender" id="man" value="남자" ${(fn:contains(mdto.gender,'남자'))?'checked':'' }> <!-- 삼항식 -->
			<lable for="man">남자</lable> 
			<input type="radio" name="gender" id="woman" value="여자" ${(fn:contains(mdto.gender,'여자'))?'checked':'' }> 
			<lable for="woman">여자</lable>
			<br/>
			<label>취미</label>
			<br/>
			<input type="checkbox" name="hobby" id="game" value="게임" ${(fn:contains(mdto.hobby,'게임'))?'checked':'' }> 
			<lable for="game">게임</lable>
			<input type="checkbox" name="hobby" id="golf" value="골프" ${(fn:contains(mdto.hobby,'골프'))?'checked':'' }> 
			<lable for="golf">골프</lable>
			<input type="checkbox" name="hobby" id="swim" value="수영" ${(fn:contains(mdto.hobby,'수영'))?'checked':'' }> 
			<lable for="swim">수영</lable>
			<input type="checkbox" name="hobby" id="run" value="조깅" ${(fn:contains(mdto.hobby,'조깅'))?'checked':'' }> 
			<lable for="run">조깅</lable>
			<input type="checkbox" name="hobby" id="read" value="독서" ${(fn:contains(mdto.hobby,'독서'))?'checked':'' }> 
			<lable for="read">독서</lable>
			<br/>
			
			<input type="submit" value="정보수정">
		</form>
		
		<div><a href="/">메인페이지 이동</a></div>
		
	</body>
</html>