package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReController {
	
	@Autowired 
	HttpSession session;
	@Autowired 
	EventService eventService;
	
	// 댓글 쓰기
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		cdto.setId("aaa"); // 임시
		// 여기 cdto 에는 날짜 및 번호가 안들어있음
		
//		String id = (String) session.getAttribute("session_id");
		
		CboardDto cboardDto = eventService.cwrite(cdto);
		
//		cboardDto에 
		return cboardDto;  // 데이터를 전달, 페이지 오픈X
	}
}
