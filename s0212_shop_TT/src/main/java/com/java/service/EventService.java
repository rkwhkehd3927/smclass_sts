package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	ArrayList<EventDto> event();

	EventDto eview(int eno);
    //하단댓글 가져오기
	ArrayList<CboardDto> clist(int eno);

}
