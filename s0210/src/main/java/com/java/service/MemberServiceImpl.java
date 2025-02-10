package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public MemberDto login(String id, String pw) {
		MemberDto memberDto = memberMapper.selectMember(id,pw);
		// Dao로 전송
		return memberDto;
	}


	@Override // 회원가입
	public void member(MemberDto mdto) {
		int result = memberMapper.insertMember(mdto);
	}
	

}
