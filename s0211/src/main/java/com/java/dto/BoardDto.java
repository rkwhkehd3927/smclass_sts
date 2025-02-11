package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	

	private int bno;
	private String btitle;
	private String bcontent;
	private String id;
	private int bgroup; // 답변 달기 시, 그룹핑용으로 필요함
	private int bstep; // 답변 달기 시, 순서 정하기
	private int bindent; // 답변 달기 시, 들여쓰기
	private int bhit;
	private Timestamp bdate;

}
