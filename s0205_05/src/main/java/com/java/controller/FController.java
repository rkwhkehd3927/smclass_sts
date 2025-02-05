package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller // url 모든 링크는 controller로 옴
public class FController {
	
	// 객체를 직접 주입할 필요 없이 @Autowired 사용
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index"; // index.jsp
	}
	
	@GetMapping("/login") // get 으로 전송 시,
	public String login() {
		System.out.println("get 전송");
		return "login";
	}
	
	@PostMapping("/doLogin") // post로 전송 시,
	public String doLogin(HttpServletRequest request) {
		session.setAttribute("session_id", "aaa"); // 세션 추가
		System.out.println("post 전송");
		return "index";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); // 세션 삭제
		return "logout";
	}

}
