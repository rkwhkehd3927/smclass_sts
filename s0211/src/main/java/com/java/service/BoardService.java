package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	
	// 게시글 전체 출력
	ArrayList<BoardDto> blist();
	
	// 작성한 글 저장
	void bwrite(BoardDto bdto);

	// 글 상세보기
	Map<String, Object> bview(int bno);

	// 글 삭제하기
	void bdelete(int bno);

	// 글 수정 페이지 오픈
	BoardDto bupdate(int bno);

	// 게시글 수정 저장
	void bupdate(BoardDto bdto);

	// 답변 달기 페이지 오픈
	BoardDto breply(int bno);

	// 답변 글 저장
	void breply(BoardDto bdto);

}
