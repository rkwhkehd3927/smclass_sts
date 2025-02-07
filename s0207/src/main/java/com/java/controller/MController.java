package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member") // 이걸 추가하면 아래에서 "/member/login" 의 경우, "/member/" 생략가능
public class MController {
	
	@Autowired HttpSession session; // 세션객체
	
//	@GetMapping("/member/login")
	@GetMapping("/login") // @RequestMapping 으로 인해 /member 생략 가능
//	@RequestMapping(method=RequestMethod.GET, value="/member/login") // 구버전
	public String login(String chk) {
		System.out.println("chk: "+chk);
		return "member/login"; // /member/login.jsp
	}
	
//	@PostMapping("/member/login")
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		
		// db에 접근해서 id,pw가 맞는지 확인
		if(id.equals("aaa") && pw.equals("1111")) { // id,pw 일치 시,
//			System.out.println("id: "+id);
//			session.removeAttribute("logoutChk"); // 세션 1개 삭제
			session.setAttribute("session_id", id); // 세션에 id 저장
//			session.setAttribute("loginChk", 1);
			return "redirect:/?chk=1"; // jsp 페이지 호출
		} else { // 불일치 시,
//			session.setAttribute("loginChk", 0);
			return "redirect:/member/login?chk=0";
		}
		
	}
	
//	@GetMapping("/member/logout")
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션 모두 삭제
		session.setAttribute("logoutChk", 1);
		return "redirect:/?outChk=1";
	}

}
