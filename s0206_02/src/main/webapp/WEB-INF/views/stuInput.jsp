<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>성적정보입력</title>
	</head>
	<body>
		<h2>성적정보입력</h2>
		
		<form action="/stuInput" method="post">
			<label>이름</label>
			<input type="text" name="name"><br/>
			<label>국어점수</label>
			<input type="text" name="kor"><br/>
			<label>영어점수</label>
			<input type="password" name="eng"><br/>
			<label>수학점수</label>
			<input type="text" name="math"><br/>
			<input type="submit" value="저장">
		</form>
		
		<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>