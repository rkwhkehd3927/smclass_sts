package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	// 게시글 전체리스트 출력 
	ArrayList<BoardDto> selectAll();
	
	// 작성한 글 저장
	int saveBoard(BoardDto bdto);

	// 게시글 상세보기
	BoardDto selectOne(int bno);

	// 게시글 삭제
	void deleteBoard(int bno);

	// 게시글 수정 저장
	void updateBoard(BoardDto bdto);

	// 답변 글 저장
	void replyBoard(BoardDto bdto);

	// 이전 게시글 정보
	BoardDto selectOnePrev(int bno);

	// 조회수 1 증가
	void updateBhit(int bno);

	// 답변 - 자식 게시글 bstep 1 증가
	void bstepUp(BoardDto bdto);

	// 다음 게시글 정보
	BoardDto selectOneNext(int bno);

}
