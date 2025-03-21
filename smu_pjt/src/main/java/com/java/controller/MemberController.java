package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@PostMapping("/login") //로그인페이지
	public String login(String memberId,String memberPw,Model model) {
		System.out.println("입력된 ID: "+memberId);
		System.out.println("입력된 PW: "+memberPw);
		
		MemberDto memberDto = memberService.findByIdAndPw(memberId,memberPw);
		if(memberDto != null) {
			System.out.println("로그인이 되었습니다.");
			session.setAttribute("session_id", memberId);
			model.addAttribute("loginChk","1");
			System.out.println("Session 객체: " + session);
			System.out.println("MemberDto 값: " + memberDto);
			System.out.println("세션에 저장된 ID: " + session.getAttribute("session_id"));
			return "redirect:/";
		}else {
			session.setAttribute("session_id", "");
			System.out.println("로그인이 되지 않았습니다.");
			model.addAttribute("loginChk","0");
			System.out.println("Session 객체: " + session);
			System.out.println("MemberDto 값: " + memberDto);
			System.out.println("세션에 저장된 ID: " + session.getAttribute("session_id"));
			return "redirect:/login?loginChk=0";
		}

	}
	
	@GetMapping("/login") // 로그인페이지 오픈
	public String login() {
		return "login";
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
