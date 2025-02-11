package com.java.controller;

import java.util.ArrayList;
import java.util.Map;

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
	
	// 게시판 페이지 오픈
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list",list);
		return "blist";
	}
	
	// 글 작성 페이지 오픈
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	// 작성한 글 저장
	@PostMapping("/board/bwrite")
	public String bwrite(BoardDto bdto) {
		boardService.bwrite(bdto);
		return "redirect:/board/blist";
	}
	
	// 글 상세보기
	@GetMapping("/board/bview")
	public String bview(@RequestParam(defaultValue = "1")int bno,
			Model model) {
//		BoardDto boardDto = boardService.bview(bno);
//		model.addAttribute("bdto",boardDto);
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
		return "bview";
	}
	
	// 글 삭제
	@GetMapping("/board/bdelete")
	public String bdelete(int bno) {
		System.out.println("bdelete bno: "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	// 글 수정 페이지 오픈
	@GetMapping("/board/bupdate")
	public String bupdate(int bno, Model model) {
		System.out.println("bupdate bno: "+bno);
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bdto",boardDto);
		return "bupdate";
	}
	
	// 글 수정 저장
	@PostMapping("/board/bupdate")
	public String bupdate(BoardDto bdto, Model model) {
		System.out.println("bupdate bno: "+bdto.getBno());
		boardService.bupdate(bdto);
		return "redirect:/board/blist";
	}
	
	// 답변 달기 페이지 오픈
	@GetMapping("/board/breply")
	public String breply(int bno, Model model) {
		System.out.println("breply bno: "+bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		return "breply";
	}
	
	// 답변 달기 저장
	@PostMapping("/board/breply")
	public String breply(BoardDto bdto) {
		System.out.println("breply bno: "+bdto.getBno());
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
	
	
	
	
}
