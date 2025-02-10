package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	@GetMapping("/board/bwrite") // 글쓰기 페이지
	public String bwrite() {
		return "bwrite";
	}

	@PostMapping("/board/bwrite") // 글쓰기 저장
	public String bwrite(BoardDto bdto) {
		boardService.bwrite(bdto);
//		return "redirect:/?chkBwrite=1"; 
		return "redirect:/board/blist"; 
	}
	
	
	@GetMapping("/board/bview") // 글 상세보기
	public String bview(@RequestParam(defaultValue="1")int bno,
			Model model) {
		// 게시글 1개 가져오기
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
	
	@GetMapping("/board/bdelete") // 게시글 삭제
	public String bdelete(int bno) {
		System.out.println("bdelete bno: "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
}
