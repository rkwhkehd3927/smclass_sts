package com.java.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.java.dto.BoardDto;

public interface BoardService {

	Page<BoardDto> findAll(Pageable pageable);

	// 게시글 가져오기
	BoardDto findById(int bno);

}
