package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@RestController
public class RController {
	
	
//	# @RestController #
//	데이터를 달라고 하는 거임
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/restpage")
	public ArrayList<BoardDto> restpage() {
		
		ArrayList<BoardDto> list = boardService.blist();
//		int [] arr = {1,2,3,4,5};
		
		// react 에서 -> /restpage 호출
//		return "여기있는 글자가 넘어감";
//		return arr;
		return list;
	}

}
