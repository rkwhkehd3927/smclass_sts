<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>게시글 작성</h2>
		<form action="boardWrite" method="post">
				<label>제목</label>
				<input type="text" name="btitle"><br/>
				<label>내용</label><br/>
				<textarea rows="10" cols="70" name="bcontent"></textarea>
				<br/>
				<label>아이디</label>
				<input type="text" name="id"><br/>
				<label>파일첨부</label>
				<input type="file" name="file"><br/>
				<br/>
				
				<input type="submit" value="저장">
			</form>
			<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>