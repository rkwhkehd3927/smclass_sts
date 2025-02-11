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
	
//	@GetMapping("/board/blist") // 게시판 페이지 오픈 및 키워드 검색
//	public String blist(
//			@RequestParam(value="page", defaultValue ="1") int page,
//			Model model) {
//		
////		ArrayList<BoardDto> list = boardService.blist(page);
////		model.addAttribute("list",list);
//		Map<String, Object> map = boardService.blist(page);
//		model.addAttribute("list",map.get("list"));
//		model.addAttribute("page",map.get("page"));
//		model.addAttribute("startpage",map.get("startpage"));
//		model.addAttribute("endpage",map.get("endpage"));
//		model.addAttribute("maxpage",map.get("maxpage"));
//		return "blist";
//	}
	
	@GetMapping("/board/blist") // 게시판 페이지 오픈 및 키워드 검색
	public String blist(
			@RequestParam(value="page", defaultValue ="1") int page,
			String category, String searchW,
			Model model) {
		
		System.out.println("category: "+category);
		System.out.println("searchW: "+searchW);
		
//		ArrayList<BoardDto> list = boardService.blist(page);
//		model.addAttribute("list",list);
		
		// 페이지 리스트 출력에 필요한 것: 페이지, 카테고리, 검색어
		Map<String, Object> map = boardService.blist(page,category,searchW);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("page",map.get("page"));
		model.addAttribute("startpage",map.get("startpage"));
		model.addAttribute("endpage",map.get("endpage"));
		model.addAttribute("maxpage",map.get("maxpage"));
		model.addAttribute("category",map.get("category"));
		model.addAttribute("searchW",map.get("searchW"));
		return "blist";
	}
	
//	@GetMapping("/board/blist") // 게시판 페이지 오픈
//	public String blist(Model model) {
//		ArrayList<BoardDto> list = boardService.blist();
//		model.addAttribute("list",list);
//		return "blist";
//	}
	
	@GetMapping("/board/bwrite") // 글쓰기 페이지 오픈
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
	public String bview(@RequestParam(defaultValue="1")int bno,int page,
			Model model) {
		// 게시글 1개 가져오기
//		BoardDto boardDto = boardService.bview(bno);
//		model.addAttribute("bdto",boardDto);
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bdto",map.get("boardDto"));
		model.addAttribute("pdto",map.get("prevDto"));
		model.addAttribute("ndto",map.get("nextDto"));
		model.addAttribute("page",page);
		return "bview";
	}
	
	@GetMapping("/board/bdelete") // 게시글 삭제
	public String bdelete(int bno) {
		System.out.println("bdelete bno: "+bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	@GetMapping("/board/bupdate") // 게시글 수정 페이지 오픈
	public String bupdate(int bno, int page, Model model) {
		System.out.println("bupdate bno: "+bno);
		BoardDto boardDto = boardService.bupdate(bno);
		System.out.println("bupdate : "+boardDto.getBno());
		model.addAttribute("bdto",boardDto);
		model.addAttribute("page",page);
		return "bupdate";
	}
	
	@PostMapping("/board/bupdate") // 게시글 수정 저장
	public String bupdate(BoardDto bdto, int page, Model model) {
		System.out.println("bupdate bno: "+bdto.getBno());
		boardService.bupdate(bdto);
		return "redirect:/board/blist?page="+page;
	}
	
	@GetMapping("/board/breply") // 답변 달기 페이지 오픈
	public String breply(int bno,int page,Model model) {
		System.out.println("breply bno: "+bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto",boardDto);
		return "breply";
	}
	
	@PostMapping("/board/breply") // 답변 달기 저장
	public String breply(BoardDto bdto) {
		System.out.println("breply bno: "+bdto.getBno());
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
}
