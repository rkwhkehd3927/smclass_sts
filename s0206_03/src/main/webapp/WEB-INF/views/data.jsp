<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>데이터전달</title>
		<style>
			h2{text-align: center;}
			table,th,td{border:1px solid black; border-collapse: collapse;}
			table{text-align:center; width: 800px; margin: 0 auto;}
			th,td{height: 40px;}
		</style>
	</head>
	<body>
		<h2>data1</h2>
		<table>
			<colgroup>
				<col width="50%">
				<col width="50%">
			</colgroup>
			<tr>
				<th>data1</th>
				<th>정보</th>
			</tr>
			<tr>
				<td>${stu.stuNo}</td>
				<td>${stu.name}</td>
			</tr>
			
		</table>
 		
 		<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>