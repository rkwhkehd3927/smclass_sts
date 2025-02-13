package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EventController {
	
	
	@Autowired
	EventService eventService;
	
	
	// 이벤트 리스트 가져오기
	@GetMapping("/event/event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.event();
		model.addAttribute("list",list);
		
		return "event/event";
	}
	
	// 이벤트 상세보기
	@GetMapping("/event/eview")
	public String event(int eno,Model model) {
		EventDto eventDto = eventService.eview(eno);
		// 하단 댓글 - eno 이벤트번호 가져가야 함
		ArrayList<CboardDto> clist = eventService.clist(eno);
		model.addAttribute("edto",eventDto);
		model.addAttribute("clist",clist);
		return "event/eview";
	}
	
	

	

}
