<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>티켓 예매</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>
    <link rel="stylesheet" href="../css/ticket/offlineTicketView.css">
    <link rel="stylesheet" href="../css/style_concert_reservation.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
    <script src="../js/ticket/offlineTicketView.js"></script>
    
</head>
<body>
    <header>
        <div class="header-left">
            <a href="/"><div class="logo"></div></a>
            <div class="artist-name">유우리 (YUURI)</div>
        </div>
        <div class="user-options">
            <span>장바구니</span>
            <span>마이페이지</span>
            <span>로그인</span>
            <span>고객센터</span>
        </div>
    </header>
    <section class="min1280px">
		<div class="max1280px">
			<div id="seat_title">
				<h2>좌석 선택</h2>
				<h3>></h3>
				<h2>결제</h2>
				<h3>></h3>
				<h2>완료</h2>
			</div>
			<hr>
			<!-- 좌석배치 -->
			<div id="seat_main">
				<div id="first_seat">
					<div>
						<h4>1F-스탠딩석</h4>
						<h2>STAGE</h2>
						<div id="seatMap1F">
							<!-- 좌석 표시를 위한 공간 -->
						</div>
					</div>
				</div>
				<div id="second_seat">
					<div>
						<h4>2F-지정석</h4>
						<div id="seatMap2F">
							<!-- 좌석 표시를 위한 공간 -->
						</div>
						<div id="wheelchair_seat">
							<div>
								<img src="">
								<img src="">
								<img src="">
								<img src="">
								<img src="">
								<img src="">
							</div>
							<div>
								<img src="">
								<img src="">
								<img src="">
								<img src="">
								<img src="">
								<img src="">
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 좌석 선택창 -->
			<div id="seat_choice">
				<!-- 좌석등급/가격 -->
				<div id="seat_class_price">
					<h2>좌석등급/가격</h2>
					<hr>
					<div>
						<div class="seat unavailable" style="background-color: #5529DD"></div>
						<h3>스탠딩석 : 80,000원</h3>
<%-- 						<h3>(잔여 : <%=f1-14==0?"매진":f1-14+"석" %>)</h3> --%>
						<h3>(잔여 : "매진":f1-14+"석" )</h3>
					</div>
					<div>
						<div class="seat unavailable" style="background-color: #EF6400"></div>
						<h3>지정석 80,000원</h3>
<%-- 						<h3>(잔여 : <%=f2-10==0?"매진":f2-10+"석" %>)</h3> --%>
						<h3>(잔여 : "매진":f2-10+"석")</h3>
					</div>
				</div>
				<!-- 선택한좌석 -->
				<div id="select_seat">
					<h2>선택한 좌석</h2>
					<hr>
					<div id="selectedSeat"></div>
				</div>
				<!-- 선택 버튼 -->
				<div id="seat_choice_button">
					<div>
<%-- 						<button onclick="prev_page('<%=eventNo%>');">이전 단계</button> --%>
						<button onclick="">이전 단계</button>
						<button onclick="seat_reset();">좌석 초기화</button>
					</div>
					<button onclick="">좌석선택 완료</button>
<%-- 					<button onclick="toPayment('<%=eventNo%>','<%=round%>','<%=choiceday%>','<%=esNo%>')">좌석선택 완료</button> --%>
				</div>
			</div>
		</div>
	</section>
	<!-----------   위에서 HTML 작업  ----------->
	<script src="../js/jquery-3.7.0.min.js"></script>
	<script src="../js/script_common.js"></script>
	<!-- 본인이 따로 적용할 외부 JS 파일 및 script 태그 -->
	<script src="../js/concert_reservations.js"></script>
	<%-- 
	<script>
		var seatA=[];
		var seatB=[];
		var seatC=[];
		var seatD=[];
		var seatE=[];
		var seatF=[];
		var seatG=[];
		var seatH=[];
		var seatI=[];
		var seatJ=[];
		var seatK=[];
		var seatL=[];
		<%for (Seat seat : seats) {%>
			esdatecheck=new Date('<%=seat.getEsDate()%>')
			esdatechoice=new Date('<%=choiceday%>')
			if(esdatecheck.getDate()==esdatechoice.getDate()){
				switch('<%=seat.getSeatRow()%>'){
					case 'A' : if('<%=seat.getIsReserved()%>'=='N'){
									seatA.push(1);break;
								}else{
									seatA.push(0);break;
								}
					case 'B' : if('<%=seat.getIsReserved()%>'=='N'){
									seatB.push(1);break;
								}else{
									seatB.push(0);break;
								}
					case 'C' : if('<%=seat.getIsReserved()%>'=='N'){
									seatC.push(1);break;
								}else{
									seatC.push(0);break;
								}
					case 'D' : if('<%=seat.getIsReserved()%>'=='N'){
									seatD.push(1);break;
								}else{
									seatD.push(0);break;
								}
					case 'E' : if('<%=seat.getIsReserved()%>'=='N'){
									seatE.push(1);break;
								}else{
									seatE.push(0);break;
								}
					case 'F' : if('<%=seat.getIsReserved()%>'=='N'){
									seatF.push(1);break;
								}else{
									seatF.push(0);break;
								}
					case 'G' : if('<%=seat.getIsReserved()%>'=='N'){
									seatG.push(1);break;
								}else{
									seatG.push(0);break;
								}
					case 'H' : if('<%=seat.getIsReserved()%>'=='N'){
									seatH.push(1);break;
								}else{
									seatH.push(0);break;
								}
					case 'I' : if('<%=seat.getIsReserved()%>'=='N'){
									seatI.push(1);break;
								}else{
									seatI.push(0);break;
								}
					case 'J' : if('<%=seat.getIsReserved()%>'=='N'){
									seatJ.push(1);break;
								}else{
									seatJ.push(0);break;
								}
					case 'K' : if('<%=seat.getIsReserved()%>'=='N'){
									seatK.push(1);break;
								}else{
									seatK.push(0);break;
								}
					case 'L' : if('<%=seat.getIsReserved()%>'=='N'){
									seatL.push(1);break;
								}else{
									seatL.push(0);break;
								}
				}
			}
		<%}%>
	</script>
	--%>
</body>
</html>
