package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DynamicInsert  // 데이터값이 null일 경우, 컬럼에서 제외
@Entity  // jpa 자동생성 - memberDto테이블 : 컬럼 생성
public class MemberDto {
	@Id // primary key생성
	@Column(length=100)  // varchar(100)
	private String id;
	@Column(nullable = false, length=100)  // varchar(100, null = false)
	private String pw;
	@Column(nullable = false, length=50)
	private String name;
	@Column(length = 20)
	private String phone;
	@ColumnDefault("'남자'")
	private String gender;
	@Column(length=100)
	private String hobby;
//	@CreationTimestamp  // sysdate와 같음
	@UpdateTimestamp
	private Timestamp mdate;
}