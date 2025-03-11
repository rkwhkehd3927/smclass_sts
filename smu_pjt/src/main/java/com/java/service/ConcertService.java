package com.java.service;


import com.java.dto.ConcertDto;
import com.java.dto.SaleConcertDto;

public interface ConcertService {

	// 콘서트 정보 조회
	ConcertDto getConcertByConcertNo(Integer concertNo);
	
	
	// 예약된 좌석 개수 가져오기
	Integer getBookedTickets(Integer concertNo); 


}
