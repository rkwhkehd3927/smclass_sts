package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	ArrayList<MemberDto> selectMemberAll(); // 미완성 메소드

}
