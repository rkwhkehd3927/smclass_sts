<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>로그아웃</title>
		<script>
			if("${chkLogin}"=="0"){
				alert("로그아웃 완료")
				location.href="/";
			}else{
				location.href="/";
			}
			
		</script>
	</head>
	<body>
	
	</body>
</html>