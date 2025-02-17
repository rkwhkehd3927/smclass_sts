package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	MemberDto login(MemberDto mdto);

	
	// 이메일 발송
//	String sendEmail(String email);
	
	String sendEmail2(String email);


	


}
