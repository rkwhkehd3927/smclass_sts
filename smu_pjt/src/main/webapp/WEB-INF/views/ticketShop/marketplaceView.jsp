<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓 상세 정보</title>
    <link rel="stylesheet" href="../css/ticket/marketplaceView.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   
     <script>
        $(document).ready(function () {
            $('#tabs .tab-menu div').click(function () {
                let index = $(this).index();
                $('#tabs .tab-content').removeClass('active');
                $('#tabs .tab-menu div').removeClass('active');
                $('#tabs .tab-content').eq(index).addClass('active');
                $('#tabs .tab-menu div').eq(index).addClass('active');
            });
        });
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
    <nav class="menu">
        <ul>
            <li><a href="#">콘서트</a></li>
            <li><a href="#">라이브</a></li>
            <li><a href="#">티켓거래</a></li>
        </ul>
    </nav>
    <div class="container">
        <div class="ticket-info">
            <p>콘서트 > 지드래곤 (G-DRAGON) > 지드래곤 2025 - 고양 (3월)</p>
            <h2>N10구역 12열</h2>
            <div class="seat-info">
                <ul>
                    <li>3층 (3F)</li>
                    <li>A</li>
                    <li>42</li>
                </ul>
            </div>
            <p class="highlight">여성명의</p>
            <p class="use_from gray-text"><strong>사용일</strong> 03.29 18:30</p>
            <p class="item_number gray-text"><strong>상품번호</strong> 5543-9417-5036</p>
        </div>
        <div class="purchase-info">
            <p><strong>장당 가격</strong> <span>₩550,000</span></p>
            <hr style="border: none; border-top: 1px solid #ddd; margin: 5px 0;">
            <p><strong>구매 수량</strong> <span>1장</span></p>
            <hr style="border: none; border-top: 1px solid #ddd; margin: 5px 0;">
            <p><strong>총 가격</strong> <span>₩550,000</span></p>
            <div class="trade-method">
                <p><strong>거래방식 선택</strong></p>
                <label>
                    <input type="checkbox"> 배송거래
                </label>
            </div>
            <button class="buy-btn">구매하기</button>
        </div>
    </div>
  	<div id="tabs" class="tabs">
        <div class="tab-menu">
            <div class="active">상품 상세 정보</div>
            <div>상품 결제/수령 안내</div>
            <div>취소/환불 안내</div>
        </div>
        <div class="tab-content active">상품 상세 정보 내용</div>
        <div class="tab-content">상품 결제/수령 안내 내용</div>
        <div class="tab-content">취소/환불 안내 내용</div>
    </div>
</body>
</html>