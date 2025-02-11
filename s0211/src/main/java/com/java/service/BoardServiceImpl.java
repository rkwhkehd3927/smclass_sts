package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper; 
	
	
	// 게시글 전체 출력
	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	// 작성한 글 저장
	@Override
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.saveBoard(bdto);
		System.out.println("result of saveBoard: "+result);
	}

	
	// 글 상세보기
	@Override
//	public BoardDto bview(int bno) {
	public Map<String, Object> bview(int bno) {
		
		Map<String, Object> map = new HashMap<>();
		
		// 현재 게시글 정보
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		// 조회수 1 증가(update)
		boardMapper.updateBhit(bno);
		
		// 이전 게시글 정보
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		
		// 다음 게시글 정보
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		
		return map;
	}

	
	// 글 삭제하기
	@Override
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}

	// 글 수정 페이지 오픈
	@Override
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	// 글 수정 저장
	@Override
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}

	// 답변 달기 페이지 오픈
	@Override
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	// 답변 글 저장
	@Override
	public void breply(BoardDto bdto) {
		
		// 같은 그룹에서 부모보다 bstep이 높은 게시글 모두 bstep +1	
		boardMapper.bstepUp(bdto);
		
		// 답변 저장
		boardMapper.replyBoard(bdto);
	}
	
	

}
