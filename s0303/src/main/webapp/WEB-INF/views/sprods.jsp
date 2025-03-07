<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>Weverse Shop Product Page</title>
  <link rel="stylesheet" href="/css/shopping.css">
  <link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
  <style>
    /* 기본 스타일 설정 */
    body {
      margin: 0;
      padding: 0;
      font-family: "Pretendard Variable", sans-serif;
      background-color: #fff;
    }
    .container {
      width: 1000px;  /* 고정된 페이지 너비 */
      margin: 0 auto;
      padding: 20px;
    }

    /* 필터 메뉴 스타일 */
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
      cursor: pointer;
    }
    .filters .filter.active {
      font-weight: bold;
      color: #000;
      border-bottom: 2px solid #000; /* 활성화된 필터 강조 표시 */
    }
    .filters label {
      margin-left: auto;  /* Hide Sold Out 체크박스를 오른쪽으로 밀기 */
      font-size: 16px;
      color: #333;
      cursor: pointer;
    }
    .filters input[type="checkbox"] {
      margin-right: 5px;
    }

    /* 제품 목록 그리드 스타일 */
    .product-list {
      display: grid;
      grid-template-columns: repeat(4, 1fr);  /* 4컬럼 그리드 */
      gap: 20px;
    }
    .product-item {
      border: 1px solid #eee;
      padding: 10px;
      box-sizing: border-box;
      position: relative;
    }
    .product-image {
      position: relative;
      margin-bottom: 8px;
    }
    .product-image img {
      width: 100%;  /* 이미지가 카드 너비에 맞게 */
      display: block;
    }
    /* Sold Out된 상품의 이미지 스타일 (흑백 처리 및 반투명) */
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
      padding: 2px 5px;
      font-size: 12px;
      border-radius: 3px;
    }
    /* 제품명 및 가격 스타일 */
    .product-name {
      font-size: 14px;
      color: #333;
      margin-bottom: 4px;
    }
    .product-price {
      font-size: 14px;
      font-weight: bold;
      color: #000;
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
      <label><input type="checkbox" id="hideSold" onchange="toggleSoldOut();" /> Hide Sold Out</label>
    </div>

    <!-- 제품 목록 -->
    <div class="product-list">
      <!-- 예시 상품 1 (품절 상품) -->
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
      <!-- 예시 상품 4 (품절 상품) -->
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


      <!-- 필요한 만큼 추가 상품 항목을 계속 추가할 수 있습니다. -->
    </div>
  </div>

  <script>
    let currentCategory = 'All';  // 현재 선택된 카테고리 (기본값: All)

    // 카테고리 필터링 함수
    function filterCategory(category, element) {
      currentCategory = category;
      // 활성화된 필터 스타일 업데이트
      document.querySelectorAll('.filter').forEach(link => {
        link.classList.toggle('active', link === element);
      });
      // 제품 표시 업데이트
      updateProductsDisplay();
    }

    // Sold Out 항목 숨김 토글 함수
    function toggleSoldOut() {
      updateProductsDisplay();
    }

    // 제품 표시 갱신 함수 (카테고리 및 Sold Out 필터 적용)
    function updateProductsDisplay() {
      const hideSold = document.getElementById('hideSold').checked;
      document.querySelectorAll('.product-item').forEach(item => {
        const matchesCategory = (currentCategory === 'All' || item.dataset.category === currentCategory);
        const isSoldOut = item.classList.contains('sold-out-item');
        if (matchesCategory && (!hideSold || !isSoldOut)) {
          // 조건에 맞는 항목 표시
          item.style.display = '';
        } else {
          // 조건에 맞지 않는 항목 숨김
          item.style.display = 'none';
        }
      });
    }
  </script>
</body>
</html>
