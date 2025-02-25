package com.java.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.web.SortDefault.SortDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// pageable - 페이지를 자동으로 계산하여 가져옴
	@GetMapping("/blist") 
//	@ResponseBody // 데이터로 리턴
	public String blist( @PageableDefault(page=0,size=10) // 1페이지당 10개
			@SortDefaults({
				@SortDefault(sort="bgroup",direction = Sort.Direction.DESC),
				@SortDefault(sort="bstep",direction = Sort.Direction.ASC)
				})
			Pageable pageable, Model model) {
		
//		List<BoardDto> list = boardService.findAll(pageable);
//		model.addAttribute("list",list);
		// List타입이 아닌 Page 객체로 변경되었음
		Page<BoardDto> page = boardService.findAll(pageable);
		List<BoardDto> list = page.getContent();
		
		
		// page 정보를 정리해서 model로 전송
		// page는 0번 부터 시작
		int nowpage = page.getPageable().getPageNumber()+1;
		int maxpage = page.getTotalPages();
		int startpage = ((nowpage-1)/10)*10+1;
		int endpage = startpage+10-1; // 1-10,11-20,21-30
		endpage = Math.min(maxpage, endpage);
		
		// 프린트
		System.out.println("nowpage: "+nowpage);
		System.out.println("maxpage: "+maxpage);
		System.out.println("startpage: "+startpage);
		System.out.println("endpage: "+endpage);
		
		
		model.addAttribute("list",list);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("maxpage",maxpage);
		model.addAttribute("startpage",startpage);
		model.addAttribute("endpage",endpage);
		return "blist";
		
//		return page;
		
	}
	
	@GetMapping("/bview")
	public String bview(int bno,Model model) {
		BoardDto boardDto = boardService.findById(bno);
//		model.addAttribute("bdto",boardDto);
		return "bview";
		
	}
}
