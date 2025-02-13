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
public class EventDto {
	
	private int eno;
	private String etitle;
	private String econtent;
	private String id;
	private int ehit;
	private Timestamp edate;
	private String efile;
	private String efile2;
	private Timestamp stdate; // 답변 달기 시, 그룹핑용으로 필요함
	private Timestamp enddate; // 답변 달기 시, 순서 정하기
	private int openchk; // 답변 달기 시, 들여쓰기

}
