package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.EventDto;

@Mapper
public interface EventMapper {

	// 글 전체 출력
	ArrayList<EventDto> selectAll();

}
