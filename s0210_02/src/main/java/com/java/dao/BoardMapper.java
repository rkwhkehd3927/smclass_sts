package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	// 게시글 전체리스트, 검색어포함 - 시작번호, 끝번호, 카테고리, 검색어
	ArrayList<BoardDto> selectAll(int startrow, int endrow, String category, String searchW);

	// 게시글 저장
	int saveBoard(BoardDto bdto);

	// 현재 게시글 정보: 1. 게시글 1개 보기, 2. 게시글 수정 및 답변 달기 시, 게시글 하나 불러오기 
	BoardDto selectOne(int bno);

	// 조회수 1 증가
	void updateBhit(int bno);
	
	// 게시글 삭제
	void deleteBoard(int bno);
	
	// 게시글 수정 저장
	void updateBoard(BoardDto bdto);

	// 답변 달기: 자식 게시글 bstep +1
	void bstepUp(BoardDto bdto);

	// 답변 저장
	void replyBoard(BoardDto bdto);

	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);
	
	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);

	
	// 하단넘버링 게시글 총개수, 검색어 총개수
	int countAll(String category, String searchW);
	


	
}
