package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// 회원 가입
	void save(MemberDto mdto);

	// 전체 회원 리스트
	List<MemberDto> findAll();

	// 회원 정보 상세 - 1명
	MemberDto findById(String id);

	// 회원 정보 삭제
	void deleteById(String id);

	// 로그인
	MemberDto findByIdAndPw(String id, String pw);

}
