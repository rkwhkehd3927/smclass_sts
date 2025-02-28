package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {
	
	
		// 메인페이지 오픈
		@GetMapping("/")
		public String index() {
			return "index";
		}
		
		// 메인페이지 오픈
		@GetMapping("/ticketMain")
		public String ticketMain() {
			return "ticketMain";
		}
		// 메인페이지 오픈
		@GetMapping("/sprods")
		public String sprods() {
			return "sprods";
		}
		// 메인페이지 오픈
		@GetMapping("/smain")
		public String smain() {
			return "smain";
		}
		// 메인페이지 오픈
		@GetMapping("/list")
		public String list() {
			return "list";
		}

}
