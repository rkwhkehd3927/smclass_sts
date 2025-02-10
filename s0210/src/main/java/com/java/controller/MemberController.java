package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	// = MemberService memberService2 = new MemberServiceImpl(); 이거랑 같음
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/member/member") // 회원가입 페이지
	public String member() {
		return "member";
	}
	
	@PostMapping("/member/member") // 회원가입정보저장 method
	public String member(String id,String pw,MemberDto mdto) {
//		System.out.println("입력된 id: "+id);
//		System.out.println("입력된 pw: "+pw);
		System.out.println("입력된 name: "+mdto.getName());
		memberService.member(mdto);
//		return "member";
		return "redirect:/";
	}
}
