package com.java.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.ConcertScheduleDto;
import com.java.dto.SeatDto;
import com.java.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository seatRepository;

	// 선택한 날짜에 해당하는 좌석 정보를 가져오는 API
	@Override
	public List<SeatDto> getSeatsBySchedule(Integer scheduleNo) {
		 return seatRepository.findByConcertScheduleDto_ScheduleNo(scheduleNo)
	                .stream()
	                .collect(Collectors.toList());
	}

	@Override
	public List<ConcertScheduleDto> getAllSchedules() {
		return seatRepository.findDistinctSchedules(); // 좌석에서 콘서트 일정 가져오기
	}

}
