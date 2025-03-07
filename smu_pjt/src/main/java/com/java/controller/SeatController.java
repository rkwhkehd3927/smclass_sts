package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.ConcertScheduleDto;
import com.java.dto.SeatDto;
import com.java.service.SeatService;

@Controller

//@RestController
//@RequestMapping("/seat")
public class SeatController {
	
	
	@Autowired
	private SeatService seatService;
	
	
	// 좌석 팝업 오픈
	@GetMapping("/ticketShop/seatPopUp")
	public String seatPopUp() {
		return "ticketShop/seatPopUp";
	}
	
	// 선택한 날짜에 해당하는 좌석 정보를 가져오는 API
	@PostMapping("/ticketShop/seatPopUp")
//	@GetMapping("/seatList")
	public ResponseEntity<List<SeatDto>> getSeatsBySchedule(ConcertScheduleDto concertscheduledto, Integer scheduleNo) {
//		scheduleNo = concertscheduledto
		List<SeatDto> seats = seatService.getSeatsBySchedule(scheduleNo);
        return ResponseEntity.ok(seats);
    }
	
	
	
	// 팝업 - 결제순서 1
	@GetMapping("/ticketShop/paymentPopUp")
	public String paymentPopUp() {
		return "ticketShop/paymentPopUp";
		
		
	}
	// 팝업 - 결제순서 2
	@GetMapping("/ticketShop/paymentPopUp2")
	public String paymentPopUp2() {
		return "ticketShop/paymentPopUp2";
		
	}
	
		
		

}
