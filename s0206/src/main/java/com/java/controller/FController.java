package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@Autowired
	HttpSession session;
	
	

	@GetMapping("/")
	public String index() {
		System.out.println("index 페이지 오픈");
		MemberDto m = new MemberDto();
//		m.pw = "1111";
//		m.getId()
		return "index";
	}
	
	@GetMapping("/login") // get
	public String login() {
		System.out.println("get login");
		return "login";
	}
	
	@PostMapping("/login") // post
	public String doLogin(HttpServletRequest request,Model model) {
//		System.out.println("id: "+id);
		System.out.println("post login");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id,pw: "+id+pw);
		
		
		// Model 사용 시,
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		session.setAttribute("session_id", id);
		return "loginInfo";
		
	}
	
	@GetMapping("/loginInfo") // get
	public String loginInfo() {
		System.out.println("get loginInfo");
		return "loginInfo";
	}
	
	
	@RequestMapping("/logout") // get, post 둘다 가능 = 해킹의 위험이 있음
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/member") // get
	public String member() {
		System.out.println("get member");
		return "member";
	}
	
	@PostMapping("/member") // post
//	public String member(HttpServletRequest request,Model model) {
	public ModelAndView member(HttpServletRequest request) {
		System.out.println("post member");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		
		String hobby= ""; // "게임,골프,수영"
		for(int i=0;i>hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		
		// Model 사용 시,
//		model.addAttribute("member",new MemberDto(id, pw, name, tel, gender, hobby));
//		return "meminfo";
		
		// ModelAndView 사용 시,
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meminfo");
		mv.addObject("member",new MemberDto(id,pw,name,tel,gender,hobby));
		return mv;
		
	}
	
	@GetMapping("/meminfo") // get
	public String meminfo() {
		System.out.println("get meminfo");
		return "meminfo";
	}
	
}
