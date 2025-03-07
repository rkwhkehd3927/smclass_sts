<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>Weverse Clone</title>
    <link rel="stylesheet" href="../css/ticket/marketplace.css">
    
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
    
    <section class="main-container">
    	<!-- 핑크배너 -->
	    <section class="banner">
	        <div class="banner-item">Fanzy Showcase &lt; Chase Our Hearts &gt;</div>
	        <div class="banner-item">2025 Fanzy Con Festival</div>
	    </section>
		<section class="reservation-container">
			    <!-- Sidebar (좌측) -->
			    <aside class="sidebar">
			        <h2>에스파</h2>
			        <select>
			            <option>전체상품보기</option>
			            <option>사용날짜</option>
			            <option>구매수량</option>
			            <option>검색 선택</option>
			        </select>
			        <div class="filter-group">
					    <h3>사용날짜</h3>
					    <select>
					        <option>전체</option>
					    </select>
					</div>
					<div class="filter-group">
					    <h3>구매수량</h3>
					    <select>
					        <option>1장</option>
					        <option>2장</option>
					    </select>
					</div>
		
			        <label>
				        <input type="checkbox" id="discounted" onchange="" />
				        정가이하
			        </label>
			        <div class="coupon-banner">
					    <img src="/images/coupon.png" alt="쿠폰 이벤트">
					    <p>2300원 할인 쿠폰</p>
					</div>
			    </aside>
	
			    <!-- 상품 리스트 (우측) -->
			    <section class="ticket-list">
			        <div class="ticket-item">
			            <div class="ticket-info">
			                <span class="ticket-date">2025.05.17 (토) 17:00</span>
			                <span class="ticket-seat">2층 (2F) 일반석</span>
			                <span class="ticket-price">₩ 269,000</span>
			            </div>
			            <button class="btn-select">선택하기</button>
			        </div>
			
			        <div class="ticket-item">
			            <div class="ticket-info">
			                <span class="ticket-date">2025.05.18 (일) 17:00</span>
			                <span class="ticket-seat">2층 (2F) 일반석</span>
			                <span class="ticket-price">₩ 278,000</span>
			            </div>
			            <button class="btn-select">선택하기</button>
			        </div>
			        
			        <div class="ticket-item">
			            <div class="ticket-info">
			                <span class="ticket-date">2025.05.18 (일) 17:00</span>
			                <span class="ticket-seat">2층 (2F) 일반석</span>
			                <span class="ticket-price">₩ 278,000</span>
			            </div>
			            <button class="btn-select">선택하기</button>
			        </div>
			        
			        <div class="ticket-item">
			            <div class="ticket-info">
			                <span class="ticket-date">2025.05.18 (일) 17:00</span>
			                <span class="ticket-seat">2층 (2F) 일반석</span>
			                <span class="ticket-price">₩ 278,000</span>
			            </div>
			            <button class="btn-select">선택하기</button>
			        </div>
			        
			        <div class="ticket-item">
			            <div class="ticket-info">
			                <span class="ticket-date">2025.05.18 (일) 17:00</span>
			                <span class="ticket-seat">2층 (2F) 일반석</span>
			                <span class="ticket-price">₩ 278,000</span>
			            </div>
			            <button class="btn-select">선택하기</button>
			        </div>
			    </section>
	    
		    <section class="payment">
		    	<button class="tradingTicket">티켓 판매 등록</button>
				<div class="payment-method">
				    <h2>결제방법</h2>
				    <div class="payment-options">
				        <label><input type="radio" name="payment" value="card"> 카드결제</label>
				        <label><input type="radio" name="payment" value="kakao"> 카카오페이</label>
				        <label><input type="radio" name="payment" value="naver"> 네이버페이</label>
				    </div>
				</div>
			</section>
		</section> <!-- reservation container -->
	
	
 
    </section>
    
    <!-- 푸터 -->
    <footer>
	        <div class="footer-links">
	        <a href="#">이용약관</a>    
	        <a href="#">서비스운영정책</a>    
	        <a href="#">유료서비스 이용약관</a>    
	        <a href="#">청소년 보호 정책</a>    
	        <a href="#"><strong>개인정보처리방침</strong></a>    
	        <a href="#">쿠키정책</a>    
	        <a href="#">쿠키 설정</a>    
	        <a href="#">입점 신청</a>    
	        <a href="#">고객센터</a>
	    </div>
	    <div class="footer-info">
		    <p>
		        상호 &nbsp;<strong>Weverse Company Inc.</strong>
		        <span class="footer-gap">|</span>
		        대표자 &nbsp;<strong>임민영</strong>
		        <span class="footer-gap">|</span>
		        전화번호 &nbsp;<strong>1544-0790</strong>
		        <span class="footer-gap">|</span>
		        FAX &nbsp;<strong>+82)-2-2144-9399</strong>
		        <span class="footer-gap">|</span>
		        주소 &nbsp;<strong> 서울 금천구 동작대로 132, 한라원앤원타워 3층</strong>
		        <span class="footer-gap">|</span>
		        사업자등록번호 &nbsp;<strong>119-86-20319</strong>
		        <span class="footer-gap">|</span>
		        <a href="#">사업자 정보 확인</a>
		    </p>
		    <p>
		        통신판매업 신고번호 &nbsp;<strong>2022-성남분당A-0557호</strong>
		        <span class="footer-gap">|</span>
		        호스팅 서비스 사업자 &nbsp;<strong>Amazon Web Services, Inc., Naver Cloud</strong>
		    </p>
		    <p>© <strong>WEVERSE COMPANY Inc.</strong> Ver 2.32.6</p>
		</div>	
	    </footer>
	</body>
	</html>