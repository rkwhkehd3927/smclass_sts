package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.stuDto;

@Service
public class BServiceImpl3 implements BService{
	
	public String slist() {
		ArrayList<stuDto> list = new ArrayList<>();
		return "stu여러개보냄3";
	}

}
