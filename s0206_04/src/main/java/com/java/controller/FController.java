package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.MemDto;
import com.java.dto.stuDto;

@Controller
public class FController {
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
		
	}
	
	@PostMapping("/meminfo")
	public String meminfo(MemDto mDto, Model model) {
		System.out.println("mDto id: "+mDto.getId());
		System.out.println("mDto hobby: "+mDto.getHobby());
		model.addAttribute("member",mDto);
		return "meminfo";
		
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuinput";
	}
	
	@PostMapping("/stuInput")
	public String stuInfo(stuDto sdto, Model model) {
		int total = sdto.getKor()+sdto.getEng()+sdto.getMath();
		double avg = total/3.0;
		sdto.setTotal(total);
		sdto.setAvg(avg);
		
		model.addAttribute("stu",sdto);
		
		return "stuInfo";
	}
	
}
