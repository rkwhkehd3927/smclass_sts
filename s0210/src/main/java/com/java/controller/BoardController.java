package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class BoardController {
		
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	// 게시글 작성
	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "boardWrite";
	}
	
	// 게시글 작성
	@PostMapping("/board/boardWrite")
	public String boardWrite(BoardDto bdto) {
		System.out.println("btitle: "+bdto.getBtitle());
		boardService.boardWrite(bdto); // 작성한 글 저장
		return "boardWrite";
	}
	
}
