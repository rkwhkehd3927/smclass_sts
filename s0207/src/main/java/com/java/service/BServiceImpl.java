package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BMapper;
import com.java.dto.BoardDto;

@Service // 이거만 넣었다 뺐다 하면 큰 대공사 필요 없이 유지보수 가능(?)
public class BServiceImpl implements BService {
	
	@Autowired BMapper bMapper;

	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = bMapper.blist();
		
		System.out.println("BServiceImpl 개수: "+list.size());
		return list;
	}

}
