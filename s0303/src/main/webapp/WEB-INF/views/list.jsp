<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>Weverse Shop Product Page</title>
  <link rel="stylesheet" href="/css/shopping.css">
  <link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
  <style>
    /* 기본 스타일 초기화 */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      font-family: "Pretendard Variable", sans-serif;
      background-color: #fff;
    }
    .container {
      width: 1200px; /* 페이지 전체 너비 */
      margin: 40px auto;
      padding: 20px;
    }

    /* 필터 메뉴 */
    .filters {
      display: flex;
      align-items: center;
      margin-bottom: 20px;
    }
    .filters .filter {
      text-decoration: none;
      color: #333;
      margin-right: 15px;
      font-size: 16px;
      padding: 8px 16px;
      border-radius: 20px;
      background-color: #f1f1f1;
      transition: background-color 0.2s ease, color 0.2s ease;
    }
    .filters .filter:hover {
      background-color: #eaeaea;
    }
    .filters .filter.active {
      font-weight: bold;
      background-color: #000;
      color: #fff;
    }
    .filters label {
      margin-left: auto;
      font-size: 16px;
      color: #333;
      cursor: pointer;
      display: flex;
      align-items: center;
    }
    .filters input[type="checkbox"] {
      margin-right: 5px;
    }

    /* 제품 목록: 5열 그리드, 카드 사이 간격 20px */
    .product-list {
      display: grid;
      grid-template-columns: repeat(5, 205px); /* 카드 폭 205px, 한 줄에 5개 */
      gap: 20px;
      justify-content: center; /* 필요하면 수정 */
    }

    /* 각 카드(텍스트 영역엔 테두리 X, 전체 높이는 유동) */
    .product-item {
      width: 205px;
      background-color: #fff;
      position: relative;
    }
    
    /* 사진 영역 (205 x 205)만 회색 배경 + 테두리 */
    .product-image {
      width: 205px;
      height: 205px;
      background-color: rgba(0, 0, 0, 0.04); /* 회색 배경 */
      border: 1px solid #ccc;    /* 테두리 */
      position: relative;
      border-radius: 10px;
      overflow: hidden;
    }
    
    .product-image img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      mix-blend-mode: multiply;
    }

    .product-image img:hover {
      transform: scale(1.02);
    }

    /* Sold Out된 상품 이미지 스타일 (흑백 처리 및 반투명) */
    .product-item.sold-out-item .product-image img {
      opacity: 0.5;
      filter: grayscale(100%);
    }
    /* Sold Out 라벨 스타일 */
    .sold-out-label {
      position: absolute;
      top: 10px;
      right: 10px;
      background: rgba(0, 0, 0, 0.6);
      color: #fff;
      padding: 4px 6px;
      font-size: 12px;
      border-radius: 3px;
    }

    /* 제품명 & 가격 (테두리 없음) */
    .product-name {
      font-size: 14px;
      color: #333;
      margin: 10px;
      margin-bottom: 4px;
      font-weight: 600;
    }
    .product-price {
      font-size: 14px;
      font-weight: bold;
      color: #000;
      margin: 0 10px 10px;
    }
  </style>
</head>
<body>
  <div class="container">
    <!-- 필터 메뉴 -->
    <div class="filters">
      <a href="#" class="filter active" onclick="filterCategory('All', this); return false;">All</a>
      <a href="#" class="filter" onclick="filterCategory('Category1', this); return false;">Category1</a>
      <a href="#" class="filter" onclick="filterCategory('Category2', this); return false;">Category2</a>
      <label>
        <input type="checkbox" id="hideSold" onchange="toggleSoldOut();" />
        Hide Sold Out
      </label>
    </div>

    <!-- 제품 목록 -->
    <div class="product-list">
      <!-- 예시 상품 1 (품절) -->
      <div class="product-item sold-out-item" data-category="Category1">
        <div class="product-image">
          <img src="/images/stelLive/masiro.jpg" alt="Product 1" />
          <span class="sold-out-label">Sold Out</span>
        </div>
        <div class="product-name">Product 1 Name</div>
        <div class="product-price">$49.99</div>
      </div>

      <!-- 예시 상품 2 -->
      <div class="product-item" data-category="Category1">
        <div class="product-image">
          <img src="/images/stelLive/lize.jpg" alt="Product 2" />
        </div>
        <div class="product-name">Product 2 Name</div>
        <div class="product-price">$29.99</div>
      </div>

      <!-- 예시 상품 3 -->
      <div class="product-item" data-category="Category2">
        <div class="product-image">
          <img src="/images/stelLive/hina.jpg" alt="Product 3" />
        </div>
        <div class="product-name">Product 3 Name</div>
        <div class="product-price">$19.99</div>
      </div>

      <!-- 예시 상품 4 (품절) -->
      <div class="product-item sold-out-item" data-category="Category2">
        <div class="product-image">
          <img src="/images/stelLive/yuni.jpg" alt="Product 4" />
          <span class="sold-out-label">Sold Out</span>
        </div>
        <div class="product-name">Product 4 Name</div>
        <div class="product-price">$9.99</div>
      </div>

      <!-- 예시 상품 5 -->
      <div class="product-item" data-category="Category1">
        <div class="product-image">
          <img src="/images/stelLive/tabi.jpg" alt="Product 5" />
        </div>
        <div class="product-name">Product 5 Name</div>
        <div class="product-price">$39.99</div>
      </div>

      <!-- 예시 상품 6 -->
      <div class="product-item" data-category="Category2">
        <div class="product-image">
          <img src="/images/stelLive/riko.jpg" alt="Product 6" />
        </div>
        <div class="product-name">Product 6 Name</div>
        <div class="product-price">$59.99</div>
      </div>
      <!-- 필요한 만큼 추가 -->
    </div>
  </div>

  <script>
    let currentCategory = 'All';

    function filterCategory(category, element) {
      currentCategory = category;
      document.querySelectorAll('.filter').forEach(link => {
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
  </script>
</body>
</html>
