package com.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	
	// 로그인 확인
	MemberDto selectLogin(MemberDto mdto);

	
	
	MemberDto selectOne();



	List<MemberDto> selectAll();
	
	
	
	
}
