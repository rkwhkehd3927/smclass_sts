$(document).ready(function() {
    const totalGroups = 10; // 총 3구역
    const rowsPerGroup = 1; // 각 구역당 6행
    const seatsPerRow = 25; // 각 행당 5석
    
    for (let g = 0; g < totalGroups; g++) {
        const group = $('<div class="seat-group"></div>'); // 구역을 나타내는 div 생성
        for (let i = 0; i < rowsPerGroup; i++) {
            const row = $('<div class="row"></div>'); // 행을 나타내는 div 생성
            for (let j = 0; j < seatsPerRow; j++) {
                const seatNumber = `${String.fromCharCode(65 + g)}${i * seatsPerRow + (j + 1)}`; // A, B, C 구역 생성
                const seat = $('<div class="seat"></div>').attr('data-seat', seatNumber);
                row.append(seat);
            }
            group.append(row);
        }
        $('#seatMap').append(group);
    }

    // 좌석 클릭 이벤트 처리
    $('.seat').on('click', function() {
        $(this).toggleClass('selected');
        updateSelectedSeats();
    });

    function updateSelectedSeats() {
        const selectedSeats = $('.seat.selected').map(function() {
            return $(this).attr('data-seat');
        }).get();
        
        $('#selected-seats').text(selectedSeats.length > 0 ? selectedSeats.join(', ') : '없음');
        $('#count').text(selectedSeats.length);
        $('#total').text(selectedSeats.length * 132000 + '원');
    }

    // 다음 단계 버튼 클릭 이벤트 처리
    $('.nextStepBtn').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/paymentPopUp';
    });
	
    $('.nextStepBtn2').on('click', function() {
        alert('다음 단계로 넘어갑니다.');
		window.location.href = '/ticketShop/paymentPopUp2';
    });
});
