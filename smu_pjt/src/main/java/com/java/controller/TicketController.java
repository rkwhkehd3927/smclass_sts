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

import com.java.dto.ArtistDto;
import com.java.dto.MemberDto;
import com.java.service.MemberService;


@Controller
public class TicketController {

	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	// 메인페이지 오픈 - get
	@GetMapping("/ticketShop/ticketMain")
	public String ticketMain(String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 1: " + memberId);
		// ID 값을 JSP로 전달 (세션에 값이 없는 경우 null 전달)
		model.addAttribute("memberId",memberId);
		return "ticketShop/ticketMain";
	}
	
	// 메인페이지 오픈 - post
	@PostMapping("/ticketShop/ticketMain")
	public String ticketMain(ArtistDto artistDto, MemberDto memberDto,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 2: " + memberId);
		
		// 회원 정보 조회
		// 세션에서 로그인된 사용자 정보 확인
		memberDto = memberService.findById(memberId);
		model.addAttribute("mdto", memberDto);
		return "ticketShop/ticketMain";
	}
	
	
	// 온라인 티켓 구매 페이지 - get
	@GetMapping("/ticketShop/onlineTicketView")
	public String onlineTicketView(String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 1: " + memberId);
		// ID 값을 JSP로 전달 (세션에 값이 없는 경우 null 전달)
		model.addAttribute("memberId",memberId);
		return "ticketShop/onlineTicketView";
		
	}
	// 온라인 티켓 구매 페이지 - post
	@PostMapping("/ticketShop/onlineTicketView")
	public String onlineTicketView(MemberDto memberDto,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 2: " + memberId);
		
		// 회원 정보 조회
		// 세션에서 로그인된 사용자 정보 확인
		memberDto = memberService.findById(memberId);
		model.addAttribute("mdto", memberDto);
		return "ticketShop/onlineTicketView";
		
	}
	
	// 오프라인 티켓 구매 페이지- get
	@GetMapping("/ticketShop/offlineTicketView")
	public String offlineTicketView(String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 1: " + memberId);
		// ID 값을 JSP로 전달 (세션에 값이 없는 경우 null 전달)
		model.addAttribute("memberId",memberId);
		return "ticketShop/offlineTicketView";
		
	}

	// 오프라인 티켓 구매 페이지 - post
	@PostMapping("/ticketShop/offlineTicketView")
	public String offlineTicketView(MemberDto memberDto,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 2: " + memberId);
		
		// 회원 정보 조회
		// 세션에서 로그인된 사용자 정보 확인
		memberDto = memberService.findById(memberId);
		model.addAttribute("mdto", memberDto);
		return "ticketShop/offlineTicketView";
	}	

	
	
	
	
	
	// 티켓 거래 양도 페이지 - get
	@GetMapping("/ticketShop/marketplace")
	public String marketplace() {
		return "ticketShop/marketplace";
	}
	
	// 티켓 거래 양도 페이지 - post
	@PostMapping("/ticketShop/marketplace")
	public String marketplace(MemberDto memberDto,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 2: " + memberId);
		
		// 회원 정보 조회
		// 세션에서 로그인된 사용자 정보 확인
		memberDto = memberService.findById(memberId);
		model.addAttribute("mdto", memberDto);
		return "ticketShop/marketplace";
	}
	
	// 티켓 거래 상세 페이지 - get
	@GetMapping("/ticketShop/marketplaceView")
	public String marketplaceView() {
		return "ticketShop/marketplaceView";
	}
	
	
	// 티켓 거래 상세 페이지 - post
	@PostMapping("/ticketShop/marketplaceView")
	public String marketplaceView(MemberDto memberDto,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 2: " + memberId);
		
		// 회원 정보 조회
		// 세션에서 로그인된 사용자 정보 확인
		memberDto = memberService.findById(memberId);
		model.addAttribute("mdto", memberDto);
		return "ticketShop/marketplaceView";
	}
	
	
	
	
	
	
	
	
}
