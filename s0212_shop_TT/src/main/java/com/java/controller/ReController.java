package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

@RestController
public class ReController {
	
	@Autowired EventService eventService;
	
	// 댓글 쓰기
	@PostMapping("/event/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : "+cdto.getEno());
		System.out.println("cpw : "+cdto.getCpw());
		System.out.println("ccontent : "+cdto.getCcontent());
		
//					CboardDto cboardDto = EventService.cwrite(cdto);
		
		return cdto;  // 데이터를 전달, 페이지 오픈X
	}
}
