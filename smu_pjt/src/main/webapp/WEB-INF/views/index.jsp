<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			if("${param.chk}" == "1"){alert("로그인 완료");}
			
			if("${param.outChk}" == "1"){alert("로그아웃");}
		</script>
		
	</head>
	<body>
		<h2>메인페이지</h2>
		<div>session_id: ${session_id}</div>
		<div>session_name: ${session_name}님 환영~</div>
<%-- 		<div>loginChk: ${chk}</div> --%>
<%-- 		<div>loginChk: ${param.chk}</div> --%>
<%-- 		<div>logoutChk: ${logoutChk}</div> --%>


		


		<button id="openPopup">좌석팝업</button>
		<script>
		    $(document).ready(function() {
		        $('#openPopup').click(function(event) {
		            event.preventDefault(); // 기본 링크 동작 방지
		            window.open('/ticketShop/seatPopUp', 'popup', 'width=1100,height=710');
		        });
		    });
		</script>

	
		<ul>
			<c:if test="${session_id == null }">
				<li><a href="/login">로그인</a></li>
				<li><a href="/member">회원가입</a></li>
				<li><a href="/ticketMain">티켓샵메인</a></li>
				<li><a href="/sprods">sprods</a></li>
				<li><a href="/smain">smain</a></li>
				<li><a href="/list">list</a></li>
				<li><a href="/ticketShop/onlineTicketView">온라인티켓상세뷰</a></li>
				<li><a href="/ticketShop/offlineTicketView">오프라인티켓상세뷰</a></li>
				<li><a href="/ticketShop/marketplace_add">거래 티켓 등록</a></li>
				<li><a href="/ticketShop/marketplaceView"> 거래 티켓 상세보기</a></li>
<!-- 				<li><a href="/ticketShop/seatPopUp_temp">좌석팝업</a></li> -->
				
				
				<hr>
<!-- 				<li><a href="/member/mlist">회원리스트</a></li> -->
				<li><a href="/blist">게시판</a></li>
				<li><a href="/board/boardWrite">게시글 작성</a></li>
				<li><a href="/board/bview/?bno=2">게시글보기</a></li>
			</c:if>
			<c:if test="${session_id != null }">
				<li><a href="/member/logout">로그아웃</a></li>
				<li><a href="/member/memInfo">회원정보</a></li>
				<li><a href="/board/blist">게시판</a></li>
				<li><a href="/board/boardWrite">게시글 작성</a></li>
				<li><a href="/ticketShop/onlineTicketView">온라인티켓상세뷰</a></li>
				<li><a href="/ticketShop/offlineTicketView">오프라인티켓상세뷰</a></li>
			</c:if>	
		</ul>
	
	</body>
</html>