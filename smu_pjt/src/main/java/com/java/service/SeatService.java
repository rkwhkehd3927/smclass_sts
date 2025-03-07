package com.java.service;

import java.util.List;

import com.java.dto.SeatDto;

public interface SeatService {

	// 선택한 날짜에 해당하는 좌석 정보를 가져오는 API
	List<SeatDto> getSeatsBySchedule(Integer scheduleNo);

}
