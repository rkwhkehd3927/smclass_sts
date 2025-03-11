$(document).ready(function() {

const products = [
    { name: "콘서트 티켓 A", price: "₩50,000", info: "단독판매", img: "https://via.placeholder.com/150" },
    { name: "뮤지컬 티켓 B", price: "₩70,000", info: "한정판", img: "https://via.placeholder.com/150" },
    { name: "연극 티켓 C", price: "₩40,000", info: "특가", img: "https://via.placeholder.com/150" },
    { name: "페스티벌 티켓 D", price: "₩90,000", info: "VIP", img: "https://via.placeholder.com/150" },
    { name: "콘서트 티켓 E", price: "₩55,000", info: "단독판매", img: "https://via.placeholder.com/150" },
    { name: "뮤지컬 티켓 F", price: "₩75,000", info: "한정판", img: "https://via.placeholder.com/150" },
    { name: "연극 티켓 G", price: "₩45,000", info: "특가", img: "https://via.placeholder.com/150" },
    { name: "페스티벌 티켓 H", price: "₩95,000", info: "VIP", img: "https://via.placeholder.com/150" }
];


	const $productList = $("#product-list"); // product-list 요소

    // 상품 목록 동적으로 생성
    $.each(products, function(index, product) {
        const productDiv = $("<div>").addClass("product").html(`
            <img src="${product.img}" alt="${product.name}">
            <p class="product-name">${product.name}</p>
            <p class="product-price">${product.price}</p>
            <p class="product-info">${product.info}</p>
        `);
        $productList.append(productDiv);  // 추가
    });

	
	// 아이템뷰 페이지 이동 - 임시
//	$('.product-item').on('click', function() {
//        alert('다음 단계로 넘어갑니다.');
//		window.location.href = '/ticketShop/offlineTicketView';
//    });
	
	$(".product-item").on("click", function () {
        let concertId = $(this).data("id"); // 해당 상품의 concert_no 값 가져오기
		console.log(concertId);
        if (concertId) {
            window.location.href = "/ticketShop/offlineTicketView?concertNO=" + concertId;
        }
    });
	
	
	$(".menu-item").click(function () {
        // 모든 메뉴에서 active 제거 후 현재 클릭한 메뉴에 추가
        $(".menu-item").removeClass("active");
        $(this).addClass("active");

        // 선택한 메뉴의 index 확인 (0: Ticket, 1: Live)
        var index = $(this).index();

		// 일단 모든 상품 숨기고
		$(".product-item").hide();
		
        if (index === 0) {
        	// Ticket 탭 클릭 시: Category1 + Category2 표시
            $(".product-item[data-category='Category-offline']").show();
        } else {
        	// Live 탭 클릭 시: Category3만 표시
            $(".product-item[data-category='Category-live']").show();
        }
    });
	
    // 페이지 로드 시 기본값 (Ticket 탭 활성화 & Ticket 리스트만 표시)
//    $(".menu-item").first().click();
	$(".product-item").show(); // 처음에 모든 상품을 보이게 함
	$(".menu-item").first().addClass("active"); // 첫 번째 메뉴만 active 추가
    
    
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

    
});