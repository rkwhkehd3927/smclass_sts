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
	
	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	// 로그인 페이지 오픈
	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	// 로그인
	@PostMapping("/member/login")
	public String login(MemberDto mdto,Model model) {
//		System.out.println("id: "+mdto.getId());
//		System.out.println("pw: "+mdto.getPw());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto != null) {
			System.out.println("session_id: "+memberDto.getId());
			session.setAttribute("session_id", memberDto.getId());
			return "redirect:/?loginChk=1";
		} else {
			model.addAttribute("loginChk",0);
			return "member/login";
			
		}
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}

}
