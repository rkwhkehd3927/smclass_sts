package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	// 인터페이스 = 미완성 메소드
	ArrayList<BoardDto> blist();

}
