package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, String>{
	
	// select * from memberDto where id=#{id} and pw=${pw} -> 자동 생성
	MemberDto findByIdAndPw(String id, String pw);

}
