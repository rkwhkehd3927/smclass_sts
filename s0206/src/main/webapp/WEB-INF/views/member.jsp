<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="member" method="post">
			<label>아이디</label>
			<input type="text" name="id"><br/>
			<label>패스워드</label>
			<input type="text" name="pw"><br/>
			<label>이름</label>
			<input type="text" name="name"><br/>
			<label>전화번호</label>
			<input type="text" name="tel"><br/>
			<label>성별</label>
			<br/>
			<input type="radio" name="gender" id="man" value="남자">
			<lable for="man">남자</lable> 
			<input type="radio" name="gender" id="woman" value="여자"> 
			<lable for="woman">여자</lable>
			<br/>
			<label>취미</label>
			<br/>
			<input type="checkbox" name="hobby" id="game" value="게임"> 
			<lable for="game">게임</lable>
			<input type="checkbox" name="hobby" id="golf" value="골프"> 
			<lable for="golf">골프</lable>
			<input type="checkbox" name="hobby" id="swim" value="수영"> 
			<lable for="swim">수영</lable>
			<input type="checkbox" name="hobby" id="run" value="조깅"> 
			<lable for="run">조깅</lable>
			<input type="checkbox" name="hobby" id="read" value="독서"> 
			<lable for="read">독서</lable>
			<br/>
			
			<input type="submit" value="회원가입">
		</form>
		
		<div><a href="/">메인페이지 이동</a></div>
		
	</body>
</html>