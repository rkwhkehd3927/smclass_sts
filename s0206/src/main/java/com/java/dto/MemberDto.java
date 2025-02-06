package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 기본생성자
//@Setter
//@Getter
@Data // Getter, Setter 를 포함하여 한번에 선언하기
public class MemberDto {
	
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	
	

}
