<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="header">
	    <select class="date-select">
	        <option value="2025-03-01 16:00">2025년 3월 1일 16:00</option>
	        <option value="2025-03-02 18:00">2025년 3월 2일 18:00</option>
	        <option value="2025-03-03 20:00">2025년 3월 3일 20:00</option>
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
            <p class="info-text">2025년 03월 20일 일괄 배송되는 상품입니다.</p>
        </div>

        <h2>예매자 확인</h2>
        <div class="section buyer-info">
            <ul>
                <li>이름: <input type="text" value="황혜진" disabled></li>
                <li>생년월일: <input type="text" placeholder="971213 (YYMMDD)"></li>
                <li>연락처: <input type="text" value="010-0000-0000" disabled></li>
                <li>이메일: <input type="text" value="rkwhkehd3927@naver.com" disabled></li>
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
            <p>정동원 이야기 3rd 전국투어 콘서트 -</p>
            <p>2025.04.12 ~ 2025.04.13</p>
            <p>부산 벡스코 오디토..</p>
            <p>8세이상 관람가능</p>
            <p>관람시간 : 150분</p>
        </div>
        <h2>MY예매정보</h2>
        <table class="my-table">
            <tr>
                <th>일시</th>
                <td>2025년 4월 12일(토) 17:00</td>
            </tr>
            <tr>
                <th>선택좌석</th>
                <td>S석 2층 E구역 3열 10번</td>
            </tr>
            <tr>
                <th>티켓금액</th>
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
                <td class="total">115,200원</td>
            </tr>
        </table>
        <button class="prevStepBtn">이전단계</button>
        <button class="nextStepBtn">다음단계</button>
    </div>
</div>

</body>
</html>
