package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.java.dto.BoardDto;

// @Repository // => Dao 원래 이거 써야됨
@Mapper// MyBatis 일때 사용
public interface BMapper {

	// 게시판리스트
	ArrayList<BoardDto> blist(); 

}
