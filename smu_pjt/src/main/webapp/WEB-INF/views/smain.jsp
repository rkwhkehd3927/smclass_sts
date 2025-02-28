<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <title>Title</title>
  <link rel="stylesheet" as="style" crossorigin
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
  <style>
    /* 전체 기본 스타일 */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
		
		a {
			text-decoration: none;
			color: black
		}
		
    body {
      font-family: "Pretendard Variable", sans-serif;
      background: #f0f0f0;
    }

    /* 메인 컨테이너 */
    .container {
      max-width: 1120px;
      margin: 0 auto;
      padding: 20px;
    }

    /* 이미지 슬라이더 스타일 */
    .slider-container {
      position: relative;
      width: 100%;
      height: 500px;
      overflow: hidden;
      border-radius: 10px;
    }

    .slide {
      position: absolute;
      width: 100%;
      height: 100%;
      object-fit: cover;
      opacity: 0;
      transition: opacity 1s ease-in-out;
    }

    .slide.active {
      opacity: 1;
    }

    .slider-btn {
      position: absolute;
      bottom: 10px;
      left: 50%;
      transform: translateX(-50%);
      padding: 10px 20px;
      background: rgba(0, 0, 0, 0.5);
      color: white;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }

    /* 제목 + 카드 묶는 래퍼 */
    .title-and-cards {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
    }

    .title-bar {
      background-color: #ccc;
      border-radius: 4px;
      padding: 20px;
      margin-bottom: 20px;
      font-size: 24px;
      font-weight: bold;
      text-align: left;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.15);
    }

    .cards {
      display: flex;
      justify-content: space-between;
      gap: 20px;
    }

    .card {
      flex: 1;
      background-color: #ffffff;
      border-radius: 8px;
      overflow: hidden;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    }

		.image-section {
		  background-color: white;
		  text-align: center;
		  overflow: hidden;
		  height: 250px; /* 원하는 높이로 설정 (예시: 200px) */
		  display: flex;
		  align-items: center;
		  justify-content: center;
		}
		
		.image-section img {
		  width: 100%; /* 부모 요소의 너비를 꽉 채움 */
		  height: 100%; /* 부모 요소의 높이를 꽉 채움 */
		  object-fit: cover; /* 이미지가 잘리지 않게 비율 유지하며 채움 */
		  transition: transform 0.15s ease;
		  will-change: transform;
		}


    .text-section {
      background-color: #F2C94C;
      padding: 15px;
      text-align: center;
      overflow: hidden;
    }

    .more-button {
      width: 100%;
      border: 2px solid #ccc;
      border-radius: 4px;
      padding: 10px;
      text-align: center;
      font-size: 16px;
      cursor: pointer;
      margin-top: 20px;
      background: none;
    }

    .more-button:hover {
      background: #f0f0f0;
    }
    .image-section:hover img {
      transform: scale(1.1);
    }

  </style>
</head>

<body>
  <div class="container">
    <div class="slider-container">
      <img src="/images/stelLive/groupimg02.png" class="slide active">
      <img src="/images/stelLive/groupimg03.jpg" class="slide">
      <img src="/images/stelLive/groupimg04.png" class="slide">
      <button class="slider-btn" onclick="nextSlide()">다음</button>
    </div>
  </div>

  <div class="container">
    <div class="title-and-cards">
      <div class="title-bar">Group Name</div>
      <div class="cards">
      
        <div class="card"><a href="/sproduct">
          <div class="image-section">
            <img src="./images/stelLive/masiro.jpg" alt="이미지 1" />
          </div>
          <div class="text-section">
            <p>Product 01</p>
          </div></a>
        </div>
        
        <div class="card"><a href="/sproduct">
          <div class="image-section">
            <img src="./images/stelLive/riko.jpg" alt="이미지 2" />
          </div>
          <div class="text-section">
            <p>Product 02</p>
          </div></a>
        </div>
        
        <div class="card"><a href="/sproduct">
          <div class="image-section">
            <img src="./images/stelLive/rin.jpg" alt="이미지 3" />
          </div>
          <div class="text-section">
            <p>Product 03</p>
          </div></a>
        </div>
        
        <div class="card"><a href="/sproduct">
          <div class="image-section">
            <img src="./images/stelLive/nana.jpg" alt="이미지 4" />
          </div>
          <div class="text-section">
            <p>Product 04</p>
          </div></a>
        </div>
        
      </div>
      <a href="splist"><button class="more-button">see All</button></a>
    </div>
  </div>

  <script>
    let slides = document.querySelectorAll(".slide");
    let currentSlide = 0;

    function nextSlide() {
        slides[currentSlide].classList.remove("active");
        currentSlide = (currentSlide + 1) % slides.length;
        slides[currentSlide].classList.add("active");
    }

    setInterval(nextSlide, 3000);
  </script>
</body>
</html>
