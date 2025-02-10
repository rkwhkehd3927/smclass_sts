package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	// 게시글 전체 리스트
	ArrayList<BoardDto> selectAll();

	void insertBoard(BoardDto bdto);

}
