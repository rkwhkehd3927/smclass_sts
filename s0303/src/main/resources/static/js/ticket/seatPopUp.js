$(document).ready(function() {

	const seatData = [
        { floor: "1층", sections: ["vip", "r", "s"], rowCounts: [2, 3, 4], cols: 18 },
        { floor: "2층", sections: ["a"], rowCounts: [5], cols: 20 }
    ];
	
	// 좌석 생성
	seatData.forEach(({ floor, sections, rowCounts, cols }) => {
        const floorDiv = $(`<div class='floor'>${floor}</div>`);
        const seatContainer = $("<div class='seat-container'></div>");
		
		sections.forEach((section, sectionIndex) => {
	        for (let i = 0; i < rowCounts[sectionIndex]; i++) {
	            const row = $("<div class='row'></div>");
	            for (let j = 0; j < cols; j++) {
	                const seatNumber = `${String.fromCharCode(65 + sectionIndex)}${i * cols + (j + 1)}`;
	                const seat = $(`<div class='seat' data-seat='${seatNumber}' data-floor='${floor}' data-section='${section}'></div>`);
	                row.append(seat);
	            }
	            seatContainer.append(row);
	        }
	    });
        $("#seatMap").append(floorDiv, seatContainer);
    });
	
	
	
	// 좌석 선택 및 남은 좌석 수 업데이트 함수
    function updateSeatsInfo() {
        const selectedSeats = $('.seat.selected').map(function() {
		 	const floor = $(this).attr('data-floor');
			const seat = $(this).attr('data-seat');
            return `${floor} ${seat}`;
        }).get();
        
        $('#selected-seats').text(selectedSeats.length > 0 ? selectedSeats.join(', ') : '없음');
        $('#count').text(selectedSeats.length);
        $('#total').text(selectedSeats.length * 132000 + '원'); // 가격 부분 추후 수정
		
		const remainingSeats = {
	        vip: 0,
	        r: 0,
	        s: 0,
	        a: 0
	    };
		
		seatData.forEach(({ sections, rowCounts, cols }) => {
	        sections.forEach((section, sectionIndex) => {
	            remainingSeats[section] += rowCounts[sectionIndex] * cols;
	        });
	    });
		
		$('.seat.selected').each(function() {
	        const section = $(this).data('section');
	        remainingSeats[section]--; // 좌석 1 감소
	    });
		
		$('#remaining-vip').text(`VIP: 잔여 ${remainingSeats.vip}석`);
	    $('#remaining-r').text(`R: 잔여 ${remainingSeats.r}석`);
	    $('#remaining-s').text(`S: 잔여 ${remainingSeats.s}석`);
	    $('#remaining-a').text(`A: 잔여 ${remainingSeats.a}석`);
    }
	
	
	
	// 좌석 클릭 이벤트 (동적 요소 적용)
    $(document).on("click", ".seat", function() {
		const section = $(this).data('section');
        $(this).toggleClass(`selected ${section}`);
		if (!$(this).hasClass('selected')) {
            $(this).removeClass('vip r s a');
        }
		updateSeatsInfo();
    });
	
	// 초기화 버튼 클릭 이벤트 처리
    $('#resetSelection').on('click', function() {
        $('.seat.selected').removeClass('selected vip r s a'); // 모든 선택된 좌석 해제
        updateSeatsInfo(); // 좌석 정보 업데이트
    });
	
	

    // 다음 단계 버튼 클릭 이벤트 처리
    $('.nextStepBtn').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/paymentPopUp';
    });
	
    $('.nextStepBtn2').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/paymentPopUp2';
    });
	
	// 초기 좌석 정보 업데이트
	updateSeatsInfo();
});
