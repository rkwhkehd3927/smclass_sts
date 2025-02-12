package com.java.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired 
	CustomerService customerService;
	
	
	// 게시글 전체 리스트
//	@GetMapping("/customer/notice")
//	public String notice(Model model) {
//		// 현재 날짜
//		Date d = new Date(); // util로 해야함
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String today = sdf.format(d);
		
//		ArrayList<BoardDto> list = customerService.notice();
//		model.addAttribute("list",list);
//		model.addAttribute("today",today);
//		System.out.println("현재날짜: "+today);
		
//		return "customer/notice";
//	}
	
	
	// 게시글 전체 리스트 + 글 10개
	@GetMapping("/customer/notice")
	public String notice(
			@RequestParam(value="page", defaultValue = "1")int page,
			String category, String searchW,
			Model model) {
		System.out.println("category: "+category);
		System.out.println("category: "+searchW);
		
		// 현재 날짜
		Date d = new Date(); // util로 해야함
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		
		
//		ArrayList<BoardDto> list = customerService.notice();
//		model.addAttribute("list",list);
		
		Map<String, Object> map = customerService.notice(page, category, searchW);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("category",map.get("category"));
		model.addAttribute("searchW",map.get("searchW"));
		model.addAttribute("today",today);
		System.out.println("현재날짜: "+today);
		
		return "customer/notice";
	}
	
	// 게시글 상세
//	@GetMapping("/customer/nview")
//	public String nview(int bno,Model model) {
		
//		BoardDto boardDto = customerService.nview(bno);
//		model.addAttribute("bdto",boardDto);
		
//		return "customer/nview";
//	}
	
	// 게시글 상세 + 이전글,다음글
	@GetMapping("/customer/nview")
	public String nview(@RequestParam(defaultValue="1")int bno,
			Model model) {
		// 게시글 1개 가져오기
//		BoardDto boardDto = customerService.nview(bno);
//		model.addAttribute("bdto",boardDto);
		
		// Map<파일이름, 모든타입을 다 담을 수 있는 Object(데이터)>
		Map<String, Object> map = customerService.nview(bno);
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
//		model.addAttribute("page",page);
		
		return "customer/nview";
	}

}
