document.addEventListener("DOMContentLoaded", function () {
      const buttons = document.querySelectorAll(".details-faq button");
      const eventImageContainer = document.querySelector(".event-image-container");
      const moreButton = document.querySelector(".more-button");
	  const scrollToTopButton = document.querySelector(".scroll-to-top");
	  const buyButton = document.querySelector(".buy-button");
      
      buttons.forEach(button => {
          button.addEventListener("click", function () {
              buttons.forEach(btn => btn.classList.remove("active")); // 모든 버튼에서 active 클래스 제거
              this.classList.add("active"); // 클릭한 버튼에 active 클래스 추가
          });
      });
      
      moreButton.addEventListener("click", function () {
          eventImageContainer.style.height = "auto";
          moreButton.style.display = "none";
      });
	  
	  scrollToTopButton.addEventListener("click", function () {
          window.scrollTo({ top: 0, behavior: "smooth" });
      });
	  
	  buyButton.addEventListener("click", function (event) {
          event.preventDefault(); // 기본 동작 방지

          // 서버에서 로그인 여부를 확인하는 로직 (예제: hidden input 값 활용)
          const isLoggedIn = document.querySelector("#isLoggedIn")?.value === "true";

          if (isLoggedIn) {
              window.open('/ticketShop/seatPopUp_temp', 'popup', 'width=1100,height=710');
          } else {
              alert("로그인 후 이용가능한 서비스입니다.");
              window.location.href = "/login"; // 로그인 페이지로 이동
          }
      });
});