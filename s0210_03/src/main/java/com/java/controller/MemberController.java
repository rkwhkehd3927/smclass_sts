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
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	HttpSession session;

	// 로그인 페이지 오픈
	@GetMapping("/member/login")
	public String login() {
		return "login";
	}
	
	// 로그인
	@PostMapping("/member/login")
	public String login(MemberDto mdto,Model model) { 
		System.out.println("login: "+mdto.getId());
		MemberDto memberDto = memberService.login(mdto);

		if(memberDto != null) {
			model.addAttribute("chkLogin","1");
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
		} else {
			model.addAttribute("chkLogin","0");
		}
		
		return "login";
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
	

}
