package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

//트랜잭션 시작과 종료: @Transactional이 붙은 메서드가 호출되면 트랜잭션이 시작되고, 메서드가 정상적으로 종료되면 트랜잭션이 커밋됩니다. 예외가 발생하면 롤백됩니다.
@Transactional 
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	int rowPerPage = 10; // 한 페이지 당 게시글의 수 
	
	@Override // 게시글 전체리스트
//	public ArrayList<BoardDto> blist(int page) {
	public Map<String, Object> blist(int page,String category, String searchW) {
		
		// 게시글 전체개수, 검색어 전체개수
		int count = boardMapper.countAll(category,searchW);
		
	// ~~~~~~~ 페이지 넘버링 e.g. 1-10,11-20
		
		// 최대 페이지 넘버링
		int maxpage = (int)Math.ceil((double)count/rowPerPage);
//		System.out.println("maxpage: "+maxpage);
		
		// 첫번째 페이지 넘버링
		int startpage = (int) ((page-1)/10)*10+1;
		
		// 마지막 페이지 넘버링
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage = maxpage;
		
		// 요청 페이지별 검색번호
		int startrow = (page-1)*rowPerPage+1; // e.g. 4페이지 (4-1)*10+1=31
		int endrow = startrow+rowPerPage-1; // 	e.g 31+10-1 = 40
		
		// 전체 리스트에 필요한 것: 시작번호, 끝번호, 카테고리, 검색어
		ArrayList<BoardDto> list = boardMapper.selectAll(startrow,endrow,category,searchW);
		
		// 리턴타입 map
		Map<String, Object> map = new HashMap<>();
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		
		return map;
	}

	@Override // 게시글 작성
	public void bwrite(BoardDto bdto) {
		int result = boardMapper.saveBoard(bdto);
		System.out.println("result of BoardServiceImpl: "+result);
	}

	@Override // 게시글 1개 보기
//	public BoardDto bview(int bno) {
	public Map<String, Object> bview(int bno) {
		Map<String, Object> map = new HashMap<>(); // 
		
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
		
//		System.out.println("prevDto 이전 게시글: "+prevDto.getBno());
//		System.out.println("nextDto 다음 게시글: "+nextDto.getBno());
		// (02-11-25) e.g. 에러발생
//		System.out.println(10/0); // error
//		return boardDto;
		return map;
	}

	@Override // 게시글 삭제
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}

	@Override // 게시글 수정
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno); // 이미 있는 거 그대로 쓰기(selectOne())
		return boardDto;
	}

	@Override // 게시글 수정 저장
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}

	@Override // 답변 달기 
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno); // 이미 있는 거 그대로 쓰기(selectOne())
		return boardDto;
	}

	@Override // 답변 저장
	public void breply(BoardDto bdto) {
		// 같은 그룹에서 부모보다 bstep이 높은 게시글 모두 +1 증가
		boardMapper.bstepUp(bdto);
		// 답변 저장
		boardMapper.replyBoard(bdto);
	}

}
