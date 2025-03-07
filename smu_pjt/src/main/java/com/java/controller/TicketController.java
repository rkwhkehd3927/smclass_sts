package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import com.java.dto.MemberDto;
//import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TicketController {

	
//	@Autowired MemberService memberService;
//	@Autowired HttpSession session;
	
	// 온라인 티켓 구매 페이지 오픈
	@GetMapping("/ticketShop/onlineTicketView")
	public String onlineTicketView() {
		return "ticketShop/onlineTicketView";
		
	}
	
	// 오프라인 티켓 구매 페이지 오픈
	@GetMapping("/ticketShop/offlineTicketView")
	public String offlineTicketView() {
		return "ticketShop/offlineTicketView";
		
	}
	
//	@PostMapping("/ticketShop/offlineTicketView")
//	public String offlineTicketView(String id,Model model) {
//		//회원정보 1명 - select One
//		MemberDto memberDto = memberService.findById(id);
//		model.addAttribute("mdto",memberDto);
//		return "ticketShop/offlineTicketView";
//		
//	}
	
	// 좌석 팝업 오픈
	@GetMapping("/ticketShop/seatPopUp")
	public String seatPopUp() {
		return "ticketShop/seatPopUp";
		
	}
	
	// 티켓 거래 양도 페이지
	@GetMapping("/ticketShop/marketplace")
	public String marketplace() {
		return "ticketShop/marketplace";
	}
	// 티켓 거래 양도 페이지
	@GetMapping("/ticketShop/marketplaceView")
	public String marketplaceView() {
		return "ticketShop/marketplaceView";
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
