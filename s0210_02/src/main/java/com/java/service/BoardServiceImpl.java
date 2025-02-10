package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override // 게시글 전체리스트
	public ArrayList<BoardDto> blist() {
		
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override // 게시글 작성
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.saveBoard(bdto);
		System.out.println("result of BoardServiceImpl: "+result);
	}

	@Override // 게시글 1개 보기
	public BoardDto bview(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		
		// 조회수 1 증가(update)
		boardMapper.updateBhit(bno);
		return boardDto;
	}

	@Override // 게시글 삭제
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}

}
