package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface CustomerMapper {

	// 전체 게시글
	ArrayList<BoardDto> selectAll(String category, String searchW);

	// 현재게시글
	BoardDto selectOne(int bno);

	// 이전게시글
	BoardDto selectOnePrev(int bno);

	// 다음게시글
	BoardDto selectOneNext(int bno);

	// 조회수 1 증가
	void updateBhit(int bno);

	// 특정 카테고리와 검색어에 해당하는 게시글의 총 개수
	int countAll(String category, String searchW);

}
