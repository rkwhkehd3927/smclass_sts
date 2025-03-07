package com.java.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.java.dto.SeatDto;

public interface SeatRepository extends JpaRepository<SeatDto, Integer> {

	List<SeatDto> findByConcertScheduleNo(int scheduleNo);


	
}
