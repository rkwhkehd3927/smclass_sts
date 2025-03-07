$(document).ready(function () {
    showDetails(); // 페이지 로드 시 기본적으로 상세정보 표시

    const buttons = $(".details-faq button");
    const eventImageContainer = $(".event-image-container");
    const moreButton = $(".more-button");
    const scrollToTopButton = $(".scroll-to-top");
    const buyButton = $(".buy-button");
	
    
    buttons.click(function () {
        buttons.removeClass("active"); // 모든 버튼에서 active 클래스 제거
        $(this).addClass("active"); // 클릭한 버튼에 active 클래스 추가
    });
    
    moreButton.click(function () {
        eventImageContainer.css("height", "auto");
        moreButton.hide();
    });
    
    scrollToTopButton.click(function () {
        $("html, body").animate({ scrollTop: 0 }, "smooth");
    });
    
    buyButton.click(function (event) {
        event.preventDefault(); // 기본 동작 방지
		

		var memberId = $('#isLoggedIn').val();

        // 서버에서 로그인 여부를 확인하는 로직 (예제: hidden input 값 활용)
		// memberId가 null이거나 빈 값인지 확인
       if (!memberId || memberId.trim() === "") {
           alert("로그인 후 이용가능한 서비스입니다."); // 경고 메시지 출력
           window.location.href = "/login"; // 로그인 페이지로 이동
       } else {
           window.open('/ticketShop/seatPopUp', 'popup', 'width=1100,height=710');
       }
//        if (memberId != null) {
//            window.open('/ticketShop/seatPopUp_temp', 'popup', 'width=1100,height=710');
//        } else {
//            alert("로그인 후 이용가능한 서비스입니다.");
//            window.location.href = "/login"; // 로그인 페이지로 이동
//        }
    });
});

function showDetails() {
    $("#event-content").show();
    $("#notice-content").hide();
    
    $(".details-faq button").eq(0).addClass("active");
    $(".details-faq button").eq(1).removeClass("active");
}

function showNotice() {
    $("#event-content").hide();
    $("#notice-content").show();
    
    $(".details-faq button").eq(0).removeClass("active");
    $(".details-faq button").eq(1).addClass("active");
}
