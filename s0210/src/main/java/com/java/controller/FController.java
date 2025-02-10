package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller

public class FController {
	
	
	@Autowired
	MemberService memberService;
	// = MemberService memberService2 = new MemberServiceImpl(); 이거랑 같음
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
//	@GetMapping("/member/member") // 회원가입 페이지
//	public String member() {
//		return "member";
//	}
//	
//	@PostMapping("/member/member") // 회원가입정보저장 method
//	public String member(String id,String pw,MemberDto mdto) {
////		System.out.println("입력된 id: "+id);
////		System.out.println("입력된 pw: "+pw);
//		System.out.println("입력된 name: "+mdto.getName());
//		memberService.member(mdto);
////		return "member";
//		return "redirect:/";
//	}
	
	@GetMapping("/member/login") // 로그인 페이지 오픈
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/member/login") // 로그인 체크
	public String login(String id, String pw, Model model) {
		MemberDto memberDto = memberService.login(id,pw);
		
		if(memberDto != null) {
			model.addAttribute("chkLogin","1"); // 로그인 성공
			session.setAttribute("session_id", id); // 세션 추가
			session.setAttribute("session_name", memberDto.getName());
		} else {
			model.addAttribute("chkLogin","0"); // 로그인 실패
		}
		return "login";
	}
	
	@GetMapping("/member/logout") // 로그아웃
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin","0");
		return "logout";
	}
	
} // class
