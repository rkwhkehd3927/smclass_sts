package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer>{
	
	// MemberDto 로그인 부분 Query
//	@Query(value="select * from memberdto where id=? and pw=?",
//			nativeQuery = true)
//	Optional<MemberDto> findByIdAndPw(String id, String pw);
	
//	@Query(value="select * from boarddto order by bgroup desc, bstep asc",
//			nativeQuery = true)
//	
//	List<BoardDto> findAll();
	
	
	
	// select * from memberdto where id=#{id} and pw=#{pw}
//	MemberDto findByIdAndPw(String id, String pw);
//
//	Page<BoardDto> findAll(Pageable pageable);

}
