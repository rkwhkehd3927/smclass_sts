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
		cdto.setId((String)session.getAttribute("session_id")); // 임시
		// 여기 cdto 에는 날짜 및 번호가 안들어있음
		
//		String id = (String) session.getAttribute("session_id");
		
		CboardDto cboardDto = eventService.cwrite(cdto);
		
//		cboardDto에 
		return cboardDto;  // 데이터를 전달, 페이지 오픈X
	}
	
	// 댓글 삭제
	@PostMapping("/event/cdelete")
	public String cdelete(int cno) {
		System.out.println("cno : "+cno);
//		String id = (String) session.getAttribute("session_id");
		// 하단 댓글 저장
		eventService.cdelete(cno);
		return "1";  // 데이터를 전달, 페이지 오픈X
	}
	
	// 댓글 수정
	@PostMapping("/event/cupdate")
	public CboardDto cupdate(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		cdto.setId("aaa");
//		String id = (String) session.getAttribute("session_id");
		// 하단 댓글 저장
		CboardDto cboardDto = eventService.cupdate(cdto);
		return cboardDto;  // 데이터를 전달, 페이지 오픈X
	}
}
