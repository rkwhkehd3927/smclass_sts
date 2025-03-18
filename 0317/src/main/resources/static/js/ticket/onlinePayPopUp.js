$(document).ready(function() {
	

    // 이전 단계 버튼 클릭 이벤트 처리
	$('.prevStepBtn').on('click', function() {
		alert('이전 단계로 돌아갑니다.');
		let scheduleNo = $('.date-select').val();
		let saleConcertNo = $(".popup").data("id");
		
		let seatNos = [];
		$(".seat-price").each(function() {
			let seatNo = $(this).data("seatno"); // data-seatNo로 접근
//            seatNos.push($(this).data("seatNo")); // 각 span에서 seatNo 값을 추출하여 배열에 추가
			if (seatNo) {
	            seatNos.push(seatNo); // seatNo가 존재하면 배열에 추가
	        }
		});
		// seatPopUp 페이지로 이동하면서 scheduleNo를 전달
        window.location.href = "/ticketShop/paymentPopUp?saleConcertNo=" + saleConcertNo + 
							   "&scheduleNo=" + scheduleNo +
							   "&seatNos=" + seatNos;
    });

	// 다음 단계 버튼 클릭 이벤트 처리
    $('.pay-btn').on('click', function() {
//        alert('결제 단계로 넘어갑니다.');
//		window.location.href = '/';

		if(confirm("상품을 구매하시겠습니까?")){
	          let buyData = {
	              name: '공연티켓',    // 카카오페이에 보낼 대표 상품명
	              totalPrice: 150000 // 총 결제금액
	          };
	        
	          $.ajax({
	              url: '/pay/orderPay',
	              type: 'POST',
	              data: buyData,
	              dataType: 'json',
	              success: function(data) {
	            	  alert("성공");
	                  console.log(data);
	                  console.log(data.next_redirect_pc_url);
	            	  location.href = data.next_redirect_pc_url;
	              },
	              error:function(){
	            	  alert("실패");
	              }
	          });
		  }



    });
	
	
});
