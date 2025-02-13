package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;


@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventMapper eventMapper;
	
	// 이벤트 글 전체
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}
	
	// 이벤트 상세 보기
	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventMapper.selectOne(eno);
		
		return eventDto;
	}

	// 하단 댓글
	@Override
	public ArrayList<CboardDto> clist(int eno) {
		System.out.println("EventServiceImpl eno : "+eno);
		ArrayList<CboardDto> clist = eventMapper.selectAllCboard(eno);
		return clist;
	}
	
	// 하단 댓글 저장
	@Override
	public CboardDto cwrite(CboardDto cdto) {
//		System.out.println("cwrite 저장 전: "+cdto.getCno()); // 0 
		eventMapper.insertCboard(cdto);
		CboardDto cboardDto = eventMapper.selectOneBoard(cdto.getCno());
//		System.out.println("cwrite 저장 후: "+cdto.getCno()); // 15
		return cboardDto;
	}

}
