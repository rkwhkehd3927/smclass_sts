package com.java.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.stuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FController {
	
	@Autowired BService b;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
//	@PostMapping("/meminfo")
//	public String meminfo(String id, String pw, String name,
//			String tel, String gender, String[] hobby, Model model) {
//		System.out.println("id: "+id);
//		System.out.println("hobby: "+Arrays.toString(hobby));
//		String hobbys ="";
//		for(int i=0;i<hobby.length;i++) {
//			if(i==0) hobbys = hobby[i];
//			else hobbys += ","+hobby[i];
//		}
//		
//		model.addAttribute("member", new MemDto(id,pw,name,tel,gender,hobbys));
//		
//		return "meminfo";
		
//	}
	
	@PostMapping("/meminfo")
	public String meminfo(MemDto mDto, Model model) {
		System.out.println("mDto id: "+mDto.getId());
		System.out.println("mDto hobby: "+mDto.getHobby());
		model.addAttribute("member",mDto);
		return "meminfo";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("/stuInput")
//	public String stuInfo(int stuNo,String name,int kor,
//			int eng, int math, Model model) {
	public String stuInfo(stuDto sdto, Model model) {
//		int total = kor+eng+math;
		int total = sdto.getKor()+sdto.getEng()+sdto.getMath();
		double avg = total/3.0;
		sdto.setTotal(total);
		sdto.setAvg(avg);
		
		model.addAttribute("stu",sdto);
		
		return "stuInfo";
	}
	
	@GetMapping("/board")
	public String board(int bno,String btitle,Model model) {
		
		model.addAttribute("bno",bno);
		model.addAttribute("btitle",btitle);
		
		return "board";
	}
	
	
	
	
	// 3가지 데이터 전달 방식
	@GetMapping("/data/{bno}")
	public String data(@RequestParam(defaultValue = "1") int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data";
	}
	@GetMapping("/data2/{bno}") // PathVariable 방식 = bno를 데이터로 받겠다는 의미
	public String data2(@PathVariable int bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data2";
	}
	@GetMapping("/data3/{bno}") // PathVariable 방식 = bno를 데이터로 "여러개" 받음
	public String data3(@PathVariable List<Integer> bno,
			Model model) {
		System.out.println("bno: "+bno);
		model.addAttribute("bno",bno);
		return "data3";
	}
	
	// 오류났다.....
	@GetMapping("/data4") // PathVariable 방식 = bno를 데이터로 "여러개" 받음
	public String data4() {
		// 객체선언
		
//		BService b = new BServiceImpl2(); // 인스턴스 메소드
//		BServiceImpl4 b4 = new BServiceImpl4(); // 인스턴스 메소드
		String str = b.slist();
		System.out.println("str: "+str);
		return "data4";
	}

}
