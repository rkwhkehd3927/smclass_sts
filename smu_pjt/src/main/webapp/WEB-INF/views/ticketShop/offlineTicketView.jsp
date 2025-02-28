<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓 예매</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>
    <link rel="stylesheet" href="../css/ticket/offlineTicketView.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <script src="../js/ticket/offlineTicketView.js"></script>
    <style>
        
    </style>
     
    <script>
      
    </script>
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
            <span>로그인</span>
            <span>고객센터</span>
        </div>
    </header>
    <main>
        <div class="ticket-container">
            <div class="ticket-image">
                <img src="/images/ticket/ticketInfo_Tsample.jpg" alt="Yuuri Arena Live 2025 at Seoul">
            </div>
            <div class="ticket-info">
                <span class="sold-out">판매중</span>
                <h1>[TICKET] YUURI ARENA LIVE 2025 at SEOUL</h1>
                <p class="artist">유우리 (YUURI)</p>
                <select class="date-select">
                    <option>DAY 1 : 2025-05-03 18:00 (KST)</option>
                    <option>DAY 2 : 2025-05-04 17:00 (KST)</option>
                </select>
    			<input type="hidden" id="isLoggedIn" value="${not empty mdto ? 'true' : 'false'}">
                <button class="buy-button">구매하기</button>
            </div>
        </div>
        <div class="details-faq">
            <button class="active">상세정보</button>
            <button>유의사항</button>
        </div>
        <hr/>
		<div class="event-image-container">
            <img src="/images/ticket/ticketInfo_sample.jpg" alt="Event Details">
        </div>
        <button class="more-button">더보기 ▼</button>
        
        <div class="scroll-to-top">
        	<i class="fa-solid fa-arrow-up fa-2x"></i>
        </div>
    </main>
</body>
</html>
