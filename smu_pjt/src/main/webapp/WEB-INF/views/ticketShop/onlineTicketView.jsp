<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓 예매</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>
    <link rel="stylesheet" href="../css/ticket/offlineTicketView.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <script src="../js/ticket/offlineTicketView.js"></script>
    
</head>
<body>
    <header>
        <div class="header-left">
            <a href="/"><div class="logo"></div></a>
            <div class="artist-name">유우리 (YUURI)</div>
        </div>
        <div class="user-options">
            <span>장바구니</span>
            <span>마이페이지</span>
            <c:if test="${memberId == null }">
				<span><a href="/login">로그인</a></span>
			</c:if>
            <c:if test="${memberId != null }">
				<span><a href="/member/logout">로그아웃</a></span>
			</c:if>	
            <span>고객센터</span>
        </div>
    </header>
    <section>
        <div class="ticket-container">
            <div class="ticket-image">
                <img src="/images/ticket/ticketInfo_Tsample.jpg" alt="Yuuri Arena Live 2025 at Seoul">
            </div>
            <div class="ticket-info">
                <span class="sold-out">판매중</span>
                <h1>[LIVE] YUURI ARENA LIVE 2025 at SEOUL</h1>
                <p class="artist">유우리 (YUURI)</p>
                <select class="date-select">
                    <option>[A] FULL PACKAGE</option>
                    <option>[B] LIVE STREAMING ONLY</option>
                    <option>[C] REPLAY ONLY</option>
                </select>
    			<input type="hidden" id="isLoggedIn" value="${memberId}">
                <button class="buy-button">구매하기</button>
            </div>
        </div>
        <div class="details-faq">
            <button class="active" onclick="showDetails()">상세정보</button>
            <button onclick="showNotice()">유의사항</button>
        </div>
        <hr/>
        
        
		<div id="event-content">
			<div class="event-image-container">
	            <img src="/images/ticket/ticketInfo_sample.jpg" alt="Event Details">
	        </div>
	        <button class="more-button">더보기 ▼</button>
        </div>
        
        <div id="notice-content" style="display: none;">
            <div class="notice-container">
                <h2>유의사항</h2>
                <p>콘서트 관련 유의사항이 여기에 표시됩니다.</p>
                <ul>
                    <li>입장은 공연 시작 30분 전부터 가능합니다.</li>
                    <li>티켓은 양도 및 재판매가 금지됩니다.</li>
                    <li>공연장 내 음식물 반입이 금지됩니다.</li>
                    <li>공연 중 사진 및 동영상 촬영이 제한될 수 있습니다.</li>
                </ul>
            </div>
        </div>
        
        
        <div class="scroll-to-top">
        	<i class="fa-solid fa-arrow-up fa-2x"></i>
        </div>
    </section>
</body>
</html>
