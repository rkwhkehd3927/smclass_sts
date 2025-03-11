package com.java.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.ConcertDto;
import com.java.dto.SaleConcertDto;
import com.java.repository.ConcertRepository;

@Service
public class ConcertServiceImpl implements ConcertService {

	
	@Autowired
	private ConcertRepository concertRepository;
	
	// 콘서트 정보 조회
	@Override
	public ConcertDto getConcertByConcertNo(Integer concertNo) {
		ConcertDto concertDto = concertRepository.findByConcertNo(concertNo);
		return concertDto;
	}

	// ✅ 예약된 좌석 개수 조회 메서드 추가
	@Override
	public Integer getBookedTickets(Integer concertNo) {
		return concertRepository.countReservedSeats(concertNo);
	}
	
	

}
