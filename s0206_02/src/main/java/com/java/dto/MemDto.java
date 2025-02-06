package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemDto {

	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	
	
//	public MemDto(String id, String pw) {
//		this.id=id;
//		this.pw=pw;
//	}
	public MemDto(String id, String name) {
		this.id=id;
		this.name=name;
	}
}
	
	