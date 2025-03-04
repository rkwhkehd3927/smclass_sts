package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);

	
	// 이메일 발송
	String sendEmail(String email);
	
	String sendEmail2(String email);

	// 리액트 회원 전체
	List<MemberDto> memberList();


	// 리액트 회원 1명
	MemberDto memberView(String id);


	


}
