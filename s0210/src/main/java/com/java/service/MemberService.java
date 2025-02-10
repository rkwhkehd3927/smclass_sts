package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	// 로그인정보 체크
	MemberDto login(String id, String pw);

	// 회원가입
	void member(MemberDto mdto); // 리턴할거 없음

}
