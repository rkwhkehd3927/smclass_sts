package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemDto;
import com.java.dto.stuDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("get 전송");
		return "login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			// 자동 형변환(String으로 받아도 int설정 가능) 
			@RequestParam("id") String id,  // form 에서 name이 "id" 인 데이터 입력받음
			@RequestParam(required = false) String pw,  //  required = false -> null 허용
			String name, // @RequestParam 생략가능, form의 이름과 같아야함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0") int eng, // defaultValue = "0" -> 값이 없으면 "0" 으로 세팅
			int math,
			Model model) {
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		
//		int kor1 = Integer.parseInt(akor);
//		int eng1 = Integer.parseInt(aeng);
//		int math1 = Integer.parseInt(amath);
//		int total = kor1+eng1+math1;
//		double avg = total/3.0;
		
		System.out.println("Data: "+id+","+pw+","+kor+","+eng+","+total+","+avg);
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("kor",kor);
		model.addAttribute("eng",eng);
		model.addAttribute("math",math);
		model.addAttribute("total",total);
		model.addAttribute("avg",avg);
//		model.addAttribute("mem",new MemDto(id, pw));
		// @Builder 이용시, 
		model.addAttribute("member",MemDto.builder().id(id).name("홍길동").build());

		return "dologin";
	}
	
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(int stuNo,String name,int kor,
			int eng, int math,
			Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
		stuDto s = stuDto.builder().stuno(stuNo).name(name).
				kor(kor).eng(eng).math(math).total(total).
				avg(avg).build();
		model.addAttribute("stu",s);
		return "doStuInput";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, 
			Model model) {
		System.out.println("bno:" +bno);
		System.out.println("btitle: "+btitle);
		
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		
		return "board";
	}

}
