package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dto.BoardDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;
	
	int rowPerPage = 10; // 한 페이지당 게시글의 수
	
	@Override
	public Map<String, Object> notice(int page,String category, String searchW) {
		
		
		// 특정 카테고리와 검색어에 해당하는 게시글의 총 개수
		int count = customerMapper.countAll(category,searchW);
		
		//~~~~~~~~~ 페이지 넘버링
		
		// 최대 페이지 넘버링
		int maxpage = (int)Math.ceil((double)count/rowPerPage);
		System.out.println("maxpage: "+maxpage);
		
		// 첫번째 페이지 넘버링
		int startpage = (int) ((page-1)/10)*10+1;
		
		// 마지막 페이지 넘버링
		int endpage = startpage+10-1;
		if(endpage>maxpage) endpage = maxpage;
		
		// 요청 페이지별 출력할 데이터 행(row) 번호 // 꺄악 오류났다
		int startrow = (page-1)*rowPerPage+1; // e.g. 4페이지 (4-1)*10+1=31
		int endrow = startrow+rowPerPage-1; // 	e.g 31+10-1 = 40
		
		// 전체 리스트 호출
		ArrayList<BoardDto> list = customerMapper.selectAll(category,searchW);
		
		Map<String, Object> map = new HashMap<>();
		map.put("page",page);
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		map.put("maxpage", maxpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		
		return map;
	}

	@Override
	public Map<String, Object> nview(int bno) {
		Map<String, Object> map = new HashMap<>();
		
		// 현재 게시글 정보
		BoardDto boardDto = customerMapper.selectOne(bno);
		
		
		// 이전 게시글 정보
		BoardDto prevDto = customerMapper.selectOnePrev(bno);
		
		// 다음 게시글 정보
		BoardDto nextDto = customerMapper.selectOneNext(bno);
		
		// 조회수 1 증가(update)
		customerMapper.updateBhit(bno);
		
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
		
		return map;
	}

	
	
	
}


