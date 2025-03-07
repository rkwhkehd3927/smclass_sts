$(document).ready(function() {

	
	
	

    // 다음 단계 버튼 클릭 이벤트 처리
    $('.prevStepBtn').on('click', function() {
        alert('이전 단계로 돌아갑니다.');
		window.location.href = '/ticketShop/seatPopUp';
    });
	
    $('.nextStepBtn').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/paymentPopUp2';
    });
	
	
});
