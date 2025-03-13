package com.java.repository;


import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.dto.ConcertDto;
import com.java.dto.ConcertScheduleDto;
import com.java.dto.SaleConcertDto;

public interface ConcertRepository extends JpaRepository<ConcertDto, Integer>{

	
	// 콘서트 번호로 콘서트 조회
	ConcertDto findByConcertNo(Integer concertNo);
	
	// ✅ concertNo 기준으로 예약된 좌석 개수 조회
    @Query("SELECT COUNT(s) FROM SeatDto s WHERE s.concertScheduleDto.concertDto.concertNo = :concertNo AND s.isReserved = true")
    int countReservedSeats(@Param("concertNo") Integer concertNo);
    
    // 해당 콘서트의 일정 리스트 조회
    @Query("SELECT cs FROM ConcertScheduleDto cs WHERE cs.concertDto.concertNo = :concertNo ORDER BY cs.scheduleDate, cs.scheduleStartTime")
	List<ConcertScheduleDto> findSchedulesByConcertNo(@Param("concertNo") Integer concertNo);



}
