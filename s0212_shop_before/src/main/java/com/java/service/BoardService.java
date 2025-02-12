package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	ArrayList<BoardDto> blist();

	void bwrite(BoardDto bdto);

	BoardDto bview(int bno);

}
