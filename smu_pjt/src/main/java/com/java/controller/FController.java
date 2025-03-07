package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	
	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
		// 메인페이지 오픈
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		
//		// 메인페이지 오픈
//		@GetMapping("/sprods")
//		public String sprods() {
//			return "sprods";
//		}
//		// 메인페이지 오픈
//		@GetMapping("/smain")
//		public String smain() {
//			return "smain";
//		}
//		// 메인페이지 오픈
//		@GetMapping("/list")
//		public String list() {
//			return "list";
//		}

}
