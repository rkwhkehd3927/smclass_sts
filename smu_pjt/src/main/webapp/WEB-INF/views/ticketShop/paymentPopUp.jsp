<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>좌석 선택 및 결제</title>
    <link rel="stylesheet" href="../css/ticket/paymentPopUp.css">
    <script src="/socket.io/socket.io.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="../js/ticket/paymentPopUp.js"></script>
</head>
<body>
	<%-- 세션 확인용 (추후 삭제) --%>
	<%= request.getSession().getAttribute("session_id") %> 
	<script>
		var sessionId = "<%= request.getSession().getAttribute("session_id") %>";
	
	    if (!sessionId || sessionId === "null") {
	        alert("재 로그인 필요");
	        window.close(); // 현재 창 닫기
	    }
	</script>

	<div class="header">
	    <select class="date-select">
	        <c:forEach var="schedule" items="${schedules}">
		        <option value="${schedule.scheduleNo}"
		        	<c:if test="${schedule.scheduleNo == selectedScheduleNo}">selected</c:if>>
		            ${schedule.scheduleDate} ${schedule.scheduleStartTime}
		        </option>
		    </c:forEach>
	    </select>
	    <div class="logo"></div> <!-- 로고 이미지 -->
	</div>
	<div class="popup">
	    <div class="seat-selection">
	        <h2>티켓수령방법</h2>
	        <div class="section delivery-info">
	            <div class="radio-box">
	                <label><input type="radio" name="delivery" value="현장수령"> 현장수령</label>
	                <label><input type="radio" name="delivery" value="배송" checked> 배송 (3,200원)</label>
	            </div>
	            <p class="info-text">2025년 06월 01일 일괄 배송되는 상품입니다.</p>
	        </div>
	
	        <h2>예매자 확인</h2>
	        <div class="section buyer-info">
	            <ul>
	                <li>이름: <input type="text" value="${memberDto.memberName}" disabled></li>
	                <li>생년월일: <input type="text" value="${fn:replace(memberDto.memberBirth, '-', '')}" placeholder="(YYYYMMDD)" disabled></li>
	                <li>연락처: <input type="text" value="${memberDto.memberPhone}"></li>
	                <li>이메일: <input type="text" value="${memberDto.memberEmail}"></li>
	            </ul>
	        </div>
	
	        <h2>배송자 정보</h2>
	        <div class="section delivery-info">
	            <div class="button-box">
	                <button>기본</button>
	                <button>황혜진</button>
	            </div>
	            <p>서울 금천구 가산디지털2로 101</p>
	            <p>010-0000-0000</p>
	            <p class="info-text">배송 받는 분의 연락처가 정확한 정보인지 입력해주세요.</p>
	        </div>
	    </div>
	
	    <div class="sidebar">
	        <div class="ticket-info">
	            <p>${concertDto.concertName}</p>
			    <p>${fn:substring(concertDto.concertStartDatetime, 0, 10)} ~ ${fn:substring(concertDto.concertEndDatetime, 0, 10)}</p>
			    <p>${concertDto.location}</p>
			    <p>${concertDto.concertAvailAge}세 이상 관람 가능</p>
			    <p>관람시간 : ${concertDto.concertDuration}분</p>
	        </div>
	        <h2>MY예매정보</h2>
	        <table class="my-table">
	            <tr>
	                <th>일시</th>
	                <td>
	                	${concertScheduleDto.scheduleDate} (${fn:substring(concertScheduleDto.scheduleStartTime, 0, 5)})
	                </td>
	            </tr>
	            <tr>
	                <th>선택좌석</th>
<%-- 
	                <td>
		            <c:forEach var="seat" items="${selectedSeats}"> 
	 				            ${seat.seatNo}석<br> 
					            ${seat.seatLevel}석 ${seat.seatFloor}층 ${seat.seatRow}열  
					            ${seat.seatCol}번 <br> 
				        </c:forEach>  
	                </td>
				        --%>
				    <td>S석 2층 E열 3번</td>
				        
	            </tr>
	            <tr>
	                <th>티켓금액</th>
<%-- 	                <td>${seatDto.seatPrice}원</td> --%>
					<td>110,000원</td>
	            </tr>
	            <tr>
	                <th>수수료</th>
	                <td>2,000원</td>
	            </tr>
	            <tr>
	                <th>배송료</th>
	                <td>3,200원</td>
	            </tr>
	            <tr class="total-row">
	                <th>총 결제금액</th>
	                <td class="total">115200원</td>
	            </tr>
	        </table>
	        <button class="prevStepBtn">이전단계</button>
	        <button class="nextStepBtn">다음단계</button>
	    </div>
	</div>

</body>
</html>
