package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventMapper eventMapper;

	
	// 글 전체 출력
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
		
	}
	
	

}
