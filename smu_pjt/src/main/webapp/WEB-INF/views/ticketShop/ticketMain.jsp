<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓 예매</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
    <script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
<!--     <link rel="stylesheet" href="../css/ticket/offlineTicketView.css"> -->
    <link rel="stylesheet" href="../css/ticket/ticketMain.css">
    
    <script>
	    $(document).ready(function () {
	        $(".menu-item").click(function () {
	            // 모든 메뉴에서 active 제거 후 현재 클릭한 메뉴에 추가
	            $(".menu-item").removeClass("active");
	            $(this).addClass("active");
	
	            // 선택한 메뉴의 index 확인 (0: Ticket, 1: Live)
	            var index = $(this).index();
	
	            if (index === 0) {
// 	                filterCategory("Category1", $(".filter-item").first());
	            	// Ticket 탭 클릭 시: Category1 + Category2 표시
	                $(".product-item").hide();
	                $(".product-item[data-category='Category1'], .product-item[data-category='Category2']").show();
	            } else {
// 	                filterCategory("Category-live", $(".filter-item").first());
	            	// Live 탭 클릭 시: Category3만 표시
	                $(".product-item").hide();
	                $(".product-item[data-category='Category-live']").show();
	            }
	        });
	
	        // 페이지 로드 시 기본값 (Ticket 탭 활성화 & Ticket 리스트만 표시)
	        $(".menu-item").first().click();
	        
	        
	        // 티켓 상세뷰
	        $(".product-item").on('click', function() {
	            alert("ㅎㅇ");
	            var category = $(this).data('category');

	            if (category === 'Category1' || category === 'Category2') {
	                window.location.href = '/ticketShop/offlineTicketView';
	            } else if (category === 'Category-live') {
	                window.location.href = '/ticketShop/onlineTicketView';
	            } else {
	                console.log('알 수 없는 카테고리: ' + category);
	            }
	        });

	        
	        
	    }); // jquery

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
            <c:if test="${memberId == null }">
				<span><a href="/login">로그인</a></span>
			</c:if>
            <c:if test="${memberId != null }">
				<span><a href="/member/logout">로그아웃</a></span>
			</c:if>	
            <span>고객센터</span>
        </div>
    </header>
    <section class="banner">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                	<img src="/images/ticket/onlineB.png" alt="배너 1">
                	<div class="banner-text">BLINK MEMBERSHIP<br>RENEWAL! 지금 바로 확인하세요</div>
                </div>
                <div class="swiper-slide">
                	<img src="/images/ticket/onlineB02.png" alt="배너 2">
                	<div class="banner-text">다양한 공연 티켓을 만나보세요!</div>
               	</div>
                <div class="swiper-slide">
                	<img src="/images/ticket/onlineB03.png" alt="배너 3">
                	<div class="banner-text">BLINK MEMBERSHIP<br>RENEWAL! 지금 바로 확인하세요</div>
                </div>
                <div class="swiper-slide">
                	<img src="/images/ticket/onlineB04.png" alt="배너 4">
                	<div class="banner-text">집에 가고 싶슴다.<br>집에 보내주시져.</div>
               	</div>
            </div>
            <div class="swiper-pagination"></div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </section>
    
    <!-- 메뉴 -->
    <div class="menu">
        <div class="menu-item active" onclick="selectMenu(this)">Ticket</div>
        <div class="menu-item" onclick="selectMenu(this)">Live</div>
    </div>
    
    <div class="filter-options">
        <div class="filter-item active" onclick="filterCategory('All', this); return false;">All</div>
        <div class="filter-item " onclick="filterCategory('Category1', this); return false;">국내배송</div>
    	  <label>
	        <input type="checkbox" id="hideSold" onchange="toggleSoldOut();" />
	        Hide Sold Out
	      </label>
    </div>
    
    <!-- 필터 메뉴 -->
    <!--  
    <div class="product-list">
        <div class="product-item">
            <img class="product-image" src="/images/ticket/item01.jpg" alt="상품 이미지">
            <div class="product-name">상품명</div>
            <div class="product-price">₩50,000</div>
            <div class="product-feature">단독판매</div>
        </div>
        <div class="product-item">
            <div class="product-image-container">
                <div class="sold-out">품절</div>
                <img class="product-image" src="/images/ticket/item01.jpg" alt="상품 이미지">
            </div>
            <div class="product-name">상품명</div>
            <div class="product-price">₩50,000</div>
            <div class="product-feature">단독판매</div>
        </div>
    </div>
    -->
    
    <!-- 제품 목록 -->
    <div class="product-list">
      <!-- 예시 상품 1 (품절) -->
      <div class="product-item sold-out-item" data-category="Category1">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 1" />
          <span class="sold-out-label">Sold Out</span>
        </div>
        <div class="product-name">Product 1 Name</div>
        <div class="product-price">$49.99</div>
        <div class="product-feature">단독판매</div>
      </div>

      <!-- 예시 상품 2 -->
      <div class="product-item" data-category="Category1">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 2" />
        </div>
        <div class="product-name">Product 2 Name</div>
        <div class="product-price">$29.99</div>
        <div class="product-feature">단독판매</div>
      </div>

      <!-- 예시 상품 3 -->
      <div class="product-item" data-category="Category2">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 3" />
        </div>
        <div class="product-name">Product 3 Name</div>
        <div class="product-price">$19.99</div>
      </div>
      
      <!-- 예시 상품 (Live1) -->
      <div class="product-item" data-category="Category-live">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 3" />
        </div>
        <div class="product-name">Product 3 Name</div>
        <div class="product-price">$19.99</div>
      </div>

      <!-- 예시 상품 4 (품절) -->
      <div class="product-item sold-out-item" data-category="Category2">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 4" />
          <span class="sold-out-label">Sold Out</span>
        </div>
        <div class="product-name">Product 4 Name</div>
        <div class="product-price">$9.99</div>
        <div class="product-feature">단독판매</div>
      </div>
      
      <!-- 예시 상품 4 (Live1-품절) -->
      <div class="product-item sold-out-item" data-category="Category-live">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 4" />
          <span class="sold-out-label">Sold Out</span>
        </div>
        <div class="product-name">Product 4 Name</div>
        <div class="product-price">$9.99</div>
        <div class="product-feature">단독판매</div>
      </div>

      <!-- 예시 상품 5 -->
      <div class="product-item" data-category="Category1">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 5" />
        </div>
        <div class="product-name">Product 5 Name</div>
        <div class="product-price">$39.99</div>
        <div class="product-feature">단독판매</div>
      </div>

      <!-- 예시 상품 6 -->
      <div class="product-item" data-category="Category2">
        <div class="product-image-container">
          <img class="product-image" src="/images/ticket/item01.jpg" alt="Product 6" />
        </div>
        <div class="product-name">Product 6 Name</div>
        <div class="product-price">$59.99</div>
      </div>
      <!-- 필요한 만큼 추가 -->
    </div>
    
    
    <script>
        var swiper = new Swiper(".swiper-container", {
            slidesPerView: 2,
            spaceBetween: 10,
            loop: true,
            autoplay: {
                delay: 3000,
                disableOnInteraction: false,
            },
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
                type: "bullets",
            },
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
            },
            speed: 1000,
            slidesPerGroup: 2,
        });
        
        function selectMenu(selected) {
            document.querySelectorAll('.menu-item').forEach(item => item.classList.remove('active'));
            selected.classList.add('active');
        }
        
       // 필터
       let currentCategory = 'All';

	    function filterCategory(category, element) {
	      currentCategory = category;
	      document.querySelectorAll('.filter-item').forEach(link => {
	        link.classList.toggle('active', link === element);
	      });
	      updateProductsDisplay();
	    }
	
	    function toggleSoldOut() {
	      updateProductsDisplay();
	    }
	
	    function updateProductsDisplay() {
	      const hideSold = document.getElementById('hideSold').checked;
	      document.querySelectorAll('.product-item').forEach(item => {
	        const matchesCategory = (currentCategory === 'All' || item.dataset.category === currentCategory);
	        const isSoldOut = item.classList.contains('sold-out-item');
	        if (matchesCategory && (!hideSold || !isSoldOut)) {
	          item.style.display = '';
	        } else {
	          item.style.display = 'none';
	        }
	      });
	    }
	    
	    // 아이템뷰 페이지 이동 - 임시
	    
        
        
    </script>
</body>
</html>


