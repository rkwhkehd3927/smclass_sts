<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/write.css">
  <style> a{text-decoration: none; color:inherit;}
  </style>
  <script>
//   function wbtn(){
// 	  alert("게시글을 저장합니다.");
//   }
  
  // 위에랑 같은 의미임
  const wbtn = () => {
	  if($(".id").val().length<1){
		  alert("아이디를 입력해야 저장 가능 ㅇㅋ?");
		  $(".id").focus();
		  return;
	  }
	  alert("게시글 저장");
	  writeFrm.submit();
  }
  </script>
  
</head>
<body>
<section>
    <a href="/"><h1>글쓰기</h1></a>
    <hr>

    <form action="bwrite" name="writeFrm" method="post">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" class="id">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="file" id="file">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" onclick="wbtn()" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/board/blist'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>