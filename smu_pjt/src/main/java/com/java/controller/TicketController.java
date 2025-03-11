package com.java.controller;

import java.util.List;

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
import com.java.dto.ConcertDto;
import com.java.dto.MemberDto;
import com.java.dto.SaleConcertDto;
import com.java.service.ConcertService;
import com.java.service.MemberService;
import com.java.service.SaleConcertService;


@Controller
public class TicketController {

	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	@Autowired ConcertService concertService;
	@Autowired SaleConcertService saleConcertService;
	
	// 메인페이지 오픈 - get
	@GetMapping("/ticketShop/ticketMain")
	public String ticketMain(String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 1: " + memberId);
		
		// 콘서트 상품 리스트 불러오기
		List<SaleConcertDto> saleConcerts = saleConcertService.getOpenSaleConcerts();
		
		// ID 값을 JSP로 전달 (세션에 값이 없는 경우 null 전달)
		model.addAttribute("memberId",memberId);
		// 콘서트 상품 리스트 불러오기
		model.addAttribute("saleConcerts",saleConcerts);
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
	
	// 오프라인 티켓 구매 페이지- get (파라미터로 concertNo 전달)
	@GetMapping("/ticketShop/offlineTicketView")
	public String offlineTicketView(@RequestParam("concertNO") Integer concertNo ,String memberId, Model model) {
		memberId = (String)session.getAttribute("session_id");
		System.out.println("세션에 저장된 ID 1: " + memberId);
		
		
        // 해당 콘서트의 판매 티켓 리스트 (판매 가능 기간, 전체 티켓 개수, 남은 티켓 개수, 솔드아웃 여부 등)
        List<SaleConcertDto> saleConcerts = saleConcertService.getSaleConcertByConcertNo(concertNo);
		
		// ID 값을 JSP로 전달 (세션에 값이 없는 경우 null 전달)
		model.addAttribute("memberId",memberId);
//		model.addAttribute("concertDto", concertDto);
		model.addAttribute("saleConcertDto", saleConcerts);
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

	
	
	// ~~~~~~~ 티켓거래
	
	
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
